package com.m2z.tools.designservice.controller.requirement;

import com.m2z.tools.designservice.controller.BaseController;
import com.m2z.tools.designservice.dto.requirement.RequirementPriorityDTO;
import com.m2z.tools.designservice.model.requirement.RequirementPriority;
import com.m2z.tools.designservice.service.requirement.RequirementPriorityService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/requirement-priorities")
public class RequirementPriorityController
        extends BaseController<RequirementPriority, RequirementPriorityDTO, Long> {
    private final RequirementPriorityService service;

    public RequirementPriorityController(RequirementPriorityService service) {
        super(service);
        this.service = service;
    }
}
