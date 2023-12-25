package com.m2z.tools.designservice.mapper.requirement;

import com.m2z.tools.designservice.dto.requirement.RequirementDTO;
import com.m2z.tools.designservice.model.requirement.Requirement;
import com.m2z.tools.shared.mapper.BaseMapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequirementMapper extends BaseMapper<Requirement, RequirementDTO, Long> {}
