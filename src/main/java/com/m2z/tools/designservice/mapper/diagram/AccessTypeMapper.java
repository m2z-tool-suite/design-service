package com.m2z.tools.designservice.mapper.diagram;

import com.m2z.tools.designservice.dto.diagram.AccessTypeDTO;
import com.m2z.tools.designservice.mapper.BaseMapper;
import com.m2z.tools.designservice.model.diagram.AccessType;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccessTypeMapper extends BaseMapper<AccessType, AccessTypeDTO, Long> {}
