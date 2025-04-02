package tech.wetech.admin3.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import tech.wetech.admin3.service.dto.UserinfoDTO;

/**
 * @author cjbi
 */
@Service
public interface SessionService {

    UserinfoDTO login(String username, String password);

    void logout(String token);

    boolean isLogin(String token);

    UserinfoDTO getLoginUserInfo(String token);

    /**
     * 获取当前登录的用户
     */
    UserinfoDTO getCurrentUserInfo();

    void refresh();

}
