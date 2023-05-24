package com.m2z.tools.designservice.mapper.diagram;

import com.m2z.tools.designservice.dto.diagram.ClassDTO;
import com.m2z.tools.designservice.dto.diagram.DiagramDTO;
import com.m2z.tools.designservice.model.diagram.Class;
import com.m2z.tools.designservice.model.diagram.Diagram;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClassMapper {
    ClassDTO toDTO(Class model);

    Class toModel(ClassDTO DTO);

    List<ClassDTO> toDTO(List<Class> model);

    List<Class> toModel(List<ClassDTO> DTO);

    @Mapping(target = "data", ignore = true)
    DiagramDTO toDTO(Diagram model);
}
