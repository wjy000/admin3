package tech.wetech.admin3.service.dto;

import tech.wetech.admin3.entity.User;

import java.time.LocalDateTime;

/**
 * @author cjbi
 */
public record LogDTO(Long id, String content, String eventBody, String typeName, LocalDateTime occurredOn, User user) {
}
