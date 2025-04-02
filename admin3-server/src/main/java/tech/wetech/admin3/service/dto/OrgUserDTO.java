package tech.wetech.admin3.service.dto;

import tech.wetech.admin3.model.User;

import java.time.LocalDateTime;

/**
 * @author cjbi
 */
public record OrgUserDTO(Long id,
                         String username,
                         String avatar,
                         User.Gender gender,
                         User.State state,
                         String orgFullName,
                         LocalDateTime createdTime) {
}
