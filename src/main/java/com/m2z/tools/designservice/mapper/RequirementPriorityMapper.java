package com.m2z.tools.designservice.mapper;

import com.m2z.tools.designservice.dto.RequirementPriorityDTO;
import com.m2z.tools.designservice.model.RequirementPriority;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequirementPriorityMapper
        extends BaseMapper<RequirementPriority, RequirementPriorityDTO, Long> {}
