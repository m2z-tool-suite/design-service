package com.m2z.tools.designservice.mapper;

import com.m2z.tools.designservice.dto.RequirementDTO;
import com.m2z.tools.designservice.model.Requirement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequirementMapper extends BaseMapper<Requirement, RequirementDTO, Long> {}
