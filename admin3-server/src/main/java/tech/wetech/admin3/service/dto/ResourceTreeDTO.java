package tech.wetech.admin3.service.dto;

import tech.wetech.admin3.model.Resource;

import java.util.List;

/**
 * @author cjbi
 */
public record ResourceTreeDTO(Long id, String name, Resource.Type type, String permission, String url, String icon,
                              List<ResourceTreeDTO> children, Long parentId, String parentName) {

}
