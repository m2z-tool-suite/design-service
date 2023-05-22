package com.m2z.tools.designservice.mapper.requirement;

import com.m2z.tools.designservice.dto.requirement.RequirementPriorityDTO;
import com.m2z.tools.designservice.mapper.BaseMapper;
import com.m2z.tools.designservice.model.requirement.RequirementPriority;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequirementPriorityMapper
        extends BaseMapper<RequirementPriority, RequirementPriorityDTO, Long> {}
