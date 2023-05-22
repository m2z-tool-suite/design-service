package com.m2z.tools.designservice.mapper.requirement;

import com.m2z.tools.designservice.dto.requirement.RequirementStatusDTO;
import com.m2z.tools.designservice.mapper.BaseMapper;
import com.m2z.tools.designservice.model.requirement.RequirementStatus;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequirementStatusMapper
        extends BaseMapper<RequirementStatus, RequirementStatusDTO, Long> {}
