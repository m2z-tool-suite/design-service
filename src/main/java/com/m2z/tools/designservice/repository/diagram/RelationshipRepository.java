package com.m2z.tools.designservice.repository.diagram;

import com.m2z.tools.designservice.model.diagram.Relationship;
import com.m2z.tools.designservice.repository.BaseRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface RelationshipRepository extends BaseRepository<Relationship, Long> {}
