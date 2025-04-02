package tech.wetech.admin3.event;

import tech.wetech.admin3.common.DomainEvent;
import tech.wetech.admin3.entity.Resource;

/**
 * @author cjbi
 */
public record ResourceUpdated(Resource resource) implements DomainEvent {
}
