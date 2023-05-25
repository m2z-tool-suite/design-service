package com.m2z.tools.designservice.dto.meta;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MetaDTO {
    private String key;

    private String name;

    private String dataSource;

    private final List<HeaderDTO> headers = new ArrayList<>();

    private final List<ChildDTO> children = new ArrayList<>();
}
