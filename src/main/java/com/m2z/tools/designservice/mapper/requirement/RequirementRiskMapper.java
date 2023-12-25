package com.m2z.tools.designservice.mapper.requirement;

import com.m2z.tools.designservice.dto.requirement.RequirementRiskDTO;
import com.m2z.tools.designservice.model.requirement.RequirementRisk;
import com.m2z.tools.shared.mapper.BaseMapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequirementRiskMapper
        extends BaseMapper<RequirementRisk, RequirementRiskDTO, Long> {}
