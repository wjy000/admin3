package tech.wetech.admin3.event;

import tech.wetech.admin3.common.DomainEvent;
import tech.wetech.admin3.model.StorageConfig;

/**
 * @author cjbi
 */
public record StorageConfigCreated(StorageConfig config) implements DomainEvent {
}
