package tech.wetech;

import org.junit.jupiter.api.Test;
import tech.wetech.admin3.common.SecurityUtil;

import java.security.NoSuchAlgorithmException;

public class 生成密码 {
    @Test
    void 计算密码() throws NoSuchAlgorithmException {
        String pwd = SecurityUtil.md5("admin", "rtu457fr5rsgj7h5");
        System.out.println(pwd);
    }
}
