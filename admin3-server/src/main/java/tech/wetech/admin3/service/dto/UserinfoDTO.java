package tech.wetech.admin3.service.dto;

import tech.wetech.admin3.entity.UserCredential;

import java.io.Serializable;
import java.util.Set;

/**
 * @author cjbi
 */
public record UserinfoDTO(String token, Long userId, String username, String avatar,String desc,
                          Credential credential, Set<String> permissions) implements Serializable {

    public record Credential(String identifier, UserCredential.IdentityType type) {
    }

}
