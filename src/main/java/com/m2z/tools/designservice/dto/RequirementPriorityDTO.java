package com.m2z.tools.designservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RequirementPriorityDTO extends BaseDTO<Long> {
    @NotBlank(message = "Title is mandatory")
    private String title;
}
