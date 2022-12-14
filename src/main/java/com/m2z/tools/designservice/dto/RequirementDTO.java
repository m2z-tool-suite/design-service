package com.m2z.tools.designservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RequirementDTO extends BaseDTO<Long> {
    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotNull(message = "Type is mandatory")
    private RequirementTypeDTO type;

    @NotNull(message = "Priority is mandatory")
    private RequirementPriorityDTO priority;

    @NotBlank(message = "Stakeholders are mandatory")
    private String stakeholders;

    @NotNull(message = "Status is mandatory")
    private RequirementStatusDTO status;

    @NotNull(message = "Effort assessment is mandatory")
    private String effortAssessment;
}
