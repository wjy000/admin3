package tech.wetech.admin3.event;

import tech.wetech.admin3.common.DomainEvent;
import tech.wetech.admin3.entity.StorageConfig;

/**
 * @author cjbi
 */
public record StorageConfigDeleted(StorageConfig config) implements DomainEvent {
}
