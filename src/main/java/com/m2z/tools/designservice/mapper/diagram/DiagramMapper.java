package com.m2z.tools.designservice.mapper.diagram;

import com.m2z.tools.designservice.dto.diagram.DiagramDTO;
import com.m2z.tools.designservice.mapper.BaseMapper;
import com.m2z.tools.designservice.model.diagram.Diagram;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiagramMapper extends BaseMapper<Diagram, DiagramDTO, Long> {}
