package com.m2z.tools.designservice.mapper.diagram;

import com.m2z.tools.designservice.dto.diagram.ClassTypeDTO;
import com.m2z.tools.designservice.mapper.BaseMapper;
import com.m2z.tools.designservice.model.diagram.ClassType;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClassTypeMapper extends BaseMapper<ClassType, ClassTypeDTO, Long> {}
