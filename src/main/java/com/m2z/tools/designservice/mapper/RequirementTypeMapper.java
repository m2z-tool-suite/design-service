package com.m2z.tools.designservice.mapper;

import com.m2z.tools.designservice.dto.RequirementTypeDTO;
import com.m2z.tools.designservice.model.RequirementType;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequirementTypeMapper
        extends BaseMapper<RequirementType, RequirementTypeDTO, Long> {}
