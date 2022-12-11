package com.m2z.tools.designservice.repository;

import com.m2z.tools.designservice.model.Diagram;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagramRepository extends BaseRepository<Diagram, Long> {
    @Override
    @Query(
            "select x from #{#entityName} x where x.deleted = false "
                    + "and (cast(x.id as string) like :search "
                    + "or x.title like :search or x.description like :search)")
    Page<Diagram> findContaining(Pageable pageable, String search);
}
