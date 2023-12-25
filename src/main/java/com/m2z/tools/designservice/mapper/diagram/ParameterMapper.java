package com.m2z.tools.designservice.mapper.diagram;

import com.m2z.tools.designservice.dto.diagram.MethodDTO;
import com.m2z.tools.designservice.dto.diagram.ParameterDTO;
import com.m2z.tools.designservice.model.diagram.Method;
import com.m2z.tools.designservice.model.diagram.Parameter;
import com.m2z.tools.shared.mapper.BaseMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ParameterMapper extends BaseMapper<Parameter, ParameterDTO, Long> {
    @Mapping(target = "class_", ignore = true)
    MethodDTO toDTO(Method model);
}
