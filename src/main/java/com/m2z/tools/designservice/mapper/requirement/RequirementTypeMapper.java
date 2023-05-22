package com.m2z.tools.designservice.mapper.requirement;

import com.m2z.tools.designservice.dto.requirement.RequirementTypeDTO;
import com.m2z.tools.designservice.mapper.BaseMapper;
import com.m2z.tools.designservice.model.requirement.RequirementType;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequirementTypeMapper
        extends BaseMapper<RequirementType, RequirementTypeDTO, Long> {}
