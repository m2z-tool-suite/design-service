package com.m2z.tools.designservice.mapper.diagram;

import com.m2z.tools.designservice.dto.diagram.ClassDTO;
import com.m2z.tools.designservice.dto.diagram.RelationshipDTO;
import com.m2z.tools.designservice.model.diagram.Class;
import com.m2z.tools.designservice.model.diagram.Relationship;
import com.m2z.tools.shared.mapper.BaseMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RelationshipMapper extends BaseMapper<Relationship, RelationshipDTO, Long> {
    @Mapping(target = "diagram", ignore = true)
    ClassDTO toDTO(Class model);
}
