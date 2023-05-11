package com.m2z.tools.designservice.controller;

import com.m2z.tools.designservice.dto.RequirementTypeDTO;
import com.m2z.tools.designservice.model.RequirementType;
import com.m2z.tools.designservice.service.RequirementTypeService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/requirement-types")
public class RequirementTypeController
        extends BaseController<RequirementType, RequirementTypeDTO, Long> {
    private final RequirementTypeService service;

    public RequirementTypeController(RequirementTypeService service) {
        super(service);
        this.service = service;
    }
}
