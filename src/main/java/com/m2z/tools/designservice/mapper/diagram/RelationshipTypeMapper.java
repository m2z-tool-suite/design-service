package com.m2z.tools.designservice.mapper.diagram;

import com.m2z.tools.designservice.dto.diagram.RelationshipTypeDTO;
import com.m2z.tools.designservice.model.diagram.RelationshipType;
import com.m2z.tools.shared.mapper.BaseMapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RelationshipTypeMapper
        extends BaseMapper<RelationshipType, RelationshipTypeDTO, Long> {}
