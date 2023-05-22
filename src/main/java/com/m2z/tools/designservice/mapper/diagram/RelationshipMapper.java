package com.m2z.tools.designservice.mapper.diagram;

import com.m2z.tools.designservice.dto.diagram.RelationshipDTO;
import com.m2z.tools.designservice.mapper.BaseMapper;
import com.m2z.tools.designservice.model.diagram.Relationship;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RelationshipMapper extends BaseMapper<Relationship, RelationshipDTO, Long> {}
