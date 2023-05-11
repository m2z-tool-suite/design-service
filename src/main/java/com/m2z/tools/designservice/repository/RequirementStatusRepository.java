package com.m2z.tools.designservice.repository;

import com.m2z.tools.designservice.model.RequirementStatus;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RequirementStatusRepository extends BaseRepository<RequirementStatus, Long> {
    @Override
    @Query(
            "select x from #{#entityName} x where x.deleted = false "
                    + "and (cast(x.id as string) like :search "
                    + "or x.title like :search)")
    Page<RequirementStatus> findContaining(Pageable pageable, String search);
}
