package com.m2z.tools.designservice.repository.diagram;

import com.m2z.tools.designservice.model.diagram.Parameter;
import com.m2z.tools.designservice.repository.BaseRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ParameterRepository extends BaseRepository<Parameter, Long> {}
