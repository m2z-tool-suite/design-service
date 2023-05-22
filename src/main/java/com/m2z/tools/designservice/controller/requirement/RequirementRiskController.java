package com.m2z.tools.designservice.controller.requirement;

import com.m2z.tools.designservice.controller.BaseController;
import com.m2z.tools.designservice.dto.requirement.RequirementRiskDTO;
import com.m2z.tools.designservice.model.requirement.RequirementRisk;
import com.m2z.tools.designservice.service.requirement.RequirementRiskService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/requirement-risks")
public class RequirementRiskController
        extends BaseController<RequirementRisk, RequirementRiskDTO, Long> {
    private final RequirementRiskService service;

    public RequirementRiskController(RequirementRiskService service) {
        super(service);
        this.service = service;
    }
}
