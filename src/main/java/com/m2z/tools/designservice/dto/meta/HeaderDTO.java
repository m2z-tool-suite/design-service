package com.m2z.tools.designservice.dto.meta;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HeaderDTO {
    private String text;

    private String value;

    private boolean sortable;

    private MetaDTO meta;
}
