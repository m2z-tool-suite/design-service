package com.m2z.tools.designservice.repository;

import com.m2z.tools.designservice.model.RequirementRisk;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RequirementRiskRepository extends BaseRepository<RequirementRisk, Long> {
    @Override
    @Query(
            "select x from #{#entityName} x where x.deleted = false "
                    + "and (cast(x.id as string) like :search "
                    + "or x.title like :search)")
    Page<RequirementRisk> findContaining(Pageable pageable, String search);
}
