package com.m2z.tools.designservice.repository.diagram;

import com.m2z.tools.designservice.model.diagram.Method;
import com.m2z.tools.designservice.repository.BaseRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface MethodRepository extends BaseRepository<Method, Long> {}
