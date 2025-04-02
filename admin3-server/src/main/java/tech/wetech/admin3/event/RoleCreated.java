package tech.wetech.admin3.event;

import tech.wetech.admin3.common.DomainEvent;
import tech.wetech.admin3.model.Role;

/**
 * @author cjbi
 */
public record RoleCreated(Role role) implements DomainEvent {
}
