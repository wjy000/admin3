package tech.wetech.admin3.event;

import tech.wetech.admin3.common.DomainEvent;
import tech.wetech.admin3.service.dto.UserinfoDTO;

/**
 * @author cjbi
 */
public record UserLoggedIn(UserinfoDTO userinfo, String ip) implements DomainEvent {
}
