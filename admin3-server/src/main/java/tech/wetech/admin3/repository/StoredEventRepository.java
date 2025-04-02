package tech.wetech.admin3.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.wetech.admin3.entity.StoredEvent;

import java.util.Set;

/**
 * @author cjbi
 */
@Repository
public interface StoredEventRepository extends JpaRepository<StoredEvent, Long> {

    Page<StoredEvent> findByTypeNameInOrderByOccurredOnDesc(Set<String> typeNames, Pageable pageable);

}
