package com.m2z.tools.designservice.repository.diagram;

import com.m2z.tools.designservice.model.diagram.Relationship;
import com.m2z.tools.shared.repository.BaseRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationshipRepository extends BaseRepository<Relationship, Long> {
    @Query(
            value =
                    "select x from #{#entityName} x where x.deleted = false and cast(x.id as string) like :search "
                            + "and x.parentClass.diagram.project = :projectId and x.childClass.diagram.project = :projectId")
    Page<Relationship> findContainingByProject(
            Pageable pageable,
            @Param("search") String search,
            @Param("projectId") String projectId);

    @Query(
            value =
                    "select x from #{#entityName} x where x.deleted = false and cast(x.id as string) like :search "
                            + "and (x.parentClass.id = :classId or x.childClass.id = :classId)")
    Page<Relationship> findContainingByClass(
            Pageable pageable, @Param("search") String search, @Param("classId") String classId);
}
