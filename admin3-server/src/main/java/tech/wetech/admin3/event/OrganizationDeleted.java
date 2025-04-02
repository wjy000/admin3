package tech.wetech.admin3.event;

import tech.wetech.admin3.common.DomainEvent;
import tech.wetech.admin3.model.Organization;

/**
 * @author cjbi
 */
public record OrganizationDeleted(Organization organization) implements DomainEvent {
}
