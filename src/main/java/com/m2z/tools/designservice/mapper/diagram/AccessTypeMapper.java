package com.m2z.tools.designservice.mapper.diagram;

import com.m2z.tools.designservice.dto.diagram.AccessTypeDTO;
import com.m2z.tools.designservice.model.diagram.AccessType;
import com.m2z.tools.shared.mapper.BaseMapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccessTypeMapper extends BaseMapper<AccessType, AccessTypeDTO, Long> {}
