package com.m2z.tools.designservice.mapper.meta;

import com.m2z.tools.designservice.dto.meta.ChildDTO;
import com.m2z.tools.designservice.dto.meta.HeaderDTO;
import com.m2z.tools.designservice.dto.meta.MetaDTO;
import com.m2z.tools.designservice.model.meta.Child;
import com.m2z.tools.designservice.model.meta.Header;
import com.m2z.tools.designservice.model.meta.Meta;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MetaMapper {
    MetaDTO toDTO(Meta model);

    List<MetaDTO> toDTO(List<Meta> model);

    @Mapping(target = "meta", ignore = true)
    HeaderDTO toDTO(Header model);

    @Mapping(target = "meta", ignore = true)
    ChildDTO toDTO(Child model);
}
