package com.m2z.tools.designservice.mapper.diagram;

import com.m2z.tools.designservice.dto.diagram.ClassDTO;
import com.m2z.tools.designservice.dto.diagram.PropertyDTO;
import com.m2z.tools.designservice.mapper.BaseMapper;
import com.m2z.tools.designservice.model.diagram.Class;
import com.m2z.tools.designservice.model.diagram.Property;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PropertyMapper extends BaseMapper<Property, PropertyDTO, Long> {
    @Mapping(target = "diagram", ignore = true)
    ClassDTO toDTO(Class model);
}
