package com.m2z.tools.designservice.mapper;

import com.m2z.tools.designservice.dto.RequirementStatusDTO;
import com.m2z.tools.designservice.model.RequirementStatus;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequirementStatusMapper
        extends BaseMapper<RequirementStatus, RequirementStatusDTO, Long> {}
