package tech.wetech.admin3.event;

import tech.wetech.admin3.common.DomainEvent;
import tech.wetech.admin3.entity.User;

/**
 * @author cjbi
 */
public record UserCreated(User user) implements DomainEvent {
}
