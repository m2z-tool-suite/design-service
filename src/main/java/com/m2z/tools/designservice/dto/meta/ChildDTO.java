package com.m2z.tools.designservice.dto.meta;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChildDTO {
    private String key;

    private String name;

    private String dataSource;

    private MetaDTO meta;
}
