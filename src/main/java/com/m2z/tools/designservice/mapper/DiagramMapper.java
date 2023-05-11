package com.m2z.tools.designservice.mapper;

import com.m2z.tools.designservice.dto.DiagramDTO;
import com.m2z.tools.designservice.model.Diagram;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiagramMapper extends BaseMapper<Diagram, DiagramDTO, Long> {}
