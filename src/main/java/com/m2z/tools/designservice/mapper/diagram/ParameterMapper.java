package com.m2z.tools.designservice.mapper.diagram;

import com.m2z.tools.designservice.dto.diagram.ParameterDTO;
import com.m2z.tools.designservice.mapper.BaseMapper;
import com.m2z.tools.designservice.model.diagram.Parameter;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParameterMapper extends BaseMapper<Parameter, ParameterDTO, Long> {}
