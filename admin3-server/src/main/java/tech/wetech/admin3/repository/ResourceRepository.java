package tech.wetech.admin3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.wetech.admin3.entity.Resource;

import java.util.Set;

/**
 * @author cjbi
 */
@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

    @Query("from Resource where id in (:resourceIds)")
    Set<Resource> findByIds(Set<Long> resourceIds);

}
