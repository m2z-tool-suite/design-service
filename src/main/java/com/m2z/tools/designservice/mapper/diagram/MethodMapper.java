package com.m2z.tools.designservice.mapper.diagram;

import com.m2z.tools.designservice.dto.diagram.MethodDTO;
import com.m2z.tools.designservice.mapper.BaseMapper;
import com.m2z.tools.designservice.model.diagram.Method;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MethodMapper extends BaseMapper<Method, MethodDTO, Long> {}
