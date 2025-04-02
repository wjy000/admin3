package tech.wetech.admin3.service.dto;

import tech.wetech.admin3.entity.Role;
import tech.wetech.admin3.entity.User;

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
