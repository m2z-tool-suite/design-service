package com.m2z.tools.designservice.repository.diagram;

import com.m2z.tools.designservice.model.diagram.Property;
import com.m2z.tools.designservice.repository.BaseRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends BaseRepository<Property, Long> {}
