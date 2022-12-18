package com.m2z.tools.designservice.mapper;

import com.m2z.tools.designservice.dto.RequirementRiskDTO;
import com.m2z.tools.designservice.model.RequirementRisk;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequirementRiskMapper
        extends BaseMapper<RequirementRisk, RequirementRiskDTO, Long> {}
