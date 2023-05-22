package com.m2z.tools.designservice.mapper.diagram;

import com.m2z.tools.designservice.dto.diagram.RelationshipTypeDTO;
import com.m2z.tools.designservice.mapper.BaseMapper;
import com.m2z.tools.designservice.model.diagram.RelationshipType;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RelationshipTypeMapper
        extends BaseMapper<RelationshipType, RelationshipTypeDTO, Long> {}
