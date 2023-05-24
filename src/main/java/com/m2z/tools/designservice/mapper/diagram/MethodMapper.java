package com.m2z.tools.designservice.mapper.diagram;

import com.m2z.tools.designservice.dto.diagram.ClassDTO;
import com.m2z.tools.designservice.dto.diagram.MethodDTO;
import com.m2z.tools.designservice.mapper.BaseMapper;
import com.m2z.tools.designservice.model.diagram.Class;
import com.m2z.tools.designservice.model.diagram.Method;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MethodMapper extends BaseMapper<Method, MethodDTO, Long> {
    @Mapping(target = "diagram", ignore = true)
    ClassDTO toDTO(Class model);
}
