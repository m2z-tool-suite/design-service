package com.m2z.tools.designservice.controller.requirement;

import com.m2z.tools.designservice.dto.requirement.RequirementTypeDTO;
import com.m2z.tools.designservice.model.requirement.RequirementType;
import com.m2z.tools.designservice.service.requirement.RequirementTypeService;
import com.m2z.tools.shared.controller.BaseController;

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
