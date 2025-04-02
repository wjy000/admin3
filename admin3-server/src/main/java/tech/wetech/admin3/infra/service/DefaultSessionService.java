package tech.wetech.admin3.infra.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import tech.wetech.admin3.common.CommonResultStatus;
import tech.wetech.admin3.common.Constants;
import tech.wetech.admin3.common.DomainEventPublisher;
import tech.wetech.admin3.common.SessionItemHolder;
import tech.wetech.admin3.event.UserLoggedIn;
import tech.wetech.admin3.event.UserLoggedOut;
import tech.wetech.admin3.exception.UserException;
import tech.wetech.admin3.entity.User;
import tech.wetech.admin3.entity.UserCredential;
import tech.wetech.admin3.repository.UserCredentialRepository;
import tech.wetech.admin3.service.SessionService;
import tech.wetech.admin3.service.dto.UserinfoDTO;

import java.util.UUID;

import static tech.wetech.admin3.entity.UserCredential.IdentityType.PASSWORD;

/**
 * @author cjbi
 */
@Service
public class DefaultSessionService implements SessionService {

    private final UserCredentialRepository userCredentialRepository;

    private final SessionManager sessionManager;

    public DefaultSessionService(UserCredentialRepository userCredentialRepository, SessionManager sessionManager) {
        this.userCredentialRepository = userCredentialRepository;
        this.sessionManager = sessionManager;
    }


    @Override
    public UserinfoDTO login(String username, String password) {
        UserCredential credential = userCredentialRepository.findCredential(username, PASSWORD)
            .orElseThrow(() -> new UserException(CommonResultStatus.UNAUTHORIZED, "密码不正确"));
        if (credential.doCredentialMatch(password)) {
            User user = credential.getUser();
            if (user.isLocked()) {
                throw new UserException(CommonResultStatus.UNAUTHORIZED, "用户已经停用，请与管理员联系");
            }
            String token = UUID.randomUUID().toString().replace("-", "");
            UserinfoDTO userinfo = new UserinfoDTO(token, user.getId(), user.getUsername(), user.getAvatar(), new UserinfoDTO.Credential(credential.getIdentifier(), credential.getIdentityType()), user.findPermissions());
            sessionManager.store(token, credential, userinfo);
            SessionItemHolder.setItem(Constants.SESSION_CURRENT_USER, userinfo);
            DomainEventPublisher.instance().publish(new UserLoggedIn(userinfo, getClientIP()));
            return userinfo;
        } else {
            throw new UserException(CommonResultStatus.UNAUTHORIZED, "密码不正确");
        }
    }

    public String getClientIP() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }

    @Override
    public void logout(String token) {
        UserinfoDTO userinfo = (UserinfoDTO) sessionManager.get(token);
        sessionManager.invalidate(token);
        DomainEventPublisher.instance().publish(new UserLoggedOut(userinfo));
    }

    @Override
    public boolean isLogin(String token) {
        return sessionManager.get(token) != null;
    }

    @Override
    public UserinfoDTO getLoginUserInfo(String token) {
        return (UserinfoDTO) sessionManager.get(token);
    }

    @Override
    public UserinfoDTO getCurrentUserInfo() {
       return  (UserinfoDTO) SessionItemHolder.getItem(Constants.SESSION_CURRENT_USER);
    }

    @Override
    public void refresh() {
        sessionManager.refresh();
    }
}
