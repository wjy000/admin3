package tech.wetech.admin3.service;

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

    void refresh();

}
