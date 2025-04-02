package tech.wetech.admin3.service.dto;

import tech.wetech.admin3.model.Role;
import tech.wetech.admin3.model.User;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author cjbi
 */
public record RoleUserDTO(Long id,
                          String username,
                          String avatar,
                          User.Gender gender,
                          User.State state,
                          Set<Role> roles,
                          LocalDateTime createdTime) {

}
