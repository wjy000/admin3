package tech.wetech.admin3.service;

import org.springframework.core.io.Resource;
import tech.wetech.admin3.entity.StorageConfig;
import tech.wetech.admin3.entity.StorageFile;
import tech.wetech.admin3.service.dto.StorageFileDTO;

import java.io.InputStream;
import java.util.List;

/**
 * @author cjbi
 */
public interface StorageService {

    List<StorageConfig> findConfigList();

    StorageConfig getConfig(Long id);

    StorageConfig createConfig(String name, StorageConfig.Type type, String endpoint, String accessKey, String secretKey, String bucketName, String address, String storagePath);

    StorageConfig updateConfig(Long id, String name, StorageConfig.Type type, String endpoint, String bucketName, String accessKey, String secretKey, String address, String storagePath);

    void deleteConfig(StorageConfig storageConfig);

    void markAsDefault(StorageConfig storageConfig);

    StorageFileDTO store(String storageId, InputStream inputStream, long contentLength, String contentType, String filename);

    void delete(String key);

    StorageFile getByKey(String key);

    Resource loadAsResource(String key);
}
