package com.m2z.tools.designservice.mapper.diagram;

import com.m2z.tools.designservice.dto.diagram.PropertyDTO;
import com.m2z.tools.designservice.mapper.BaseMapper;
import com.m2z.tools.designservice.model.diagram.Property;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PropertyMapper extends BaseMapper<Property, PropertyDTO, Long> {}
