package com.m2z.tools.designservice.controller.requirement;

import com.m2z.tools.designservice.dto.requirement.RequirementStatusDTO;
import com.m2z.tools.designservice.model.requirement.RequirementStatus;
import com.m2z.tools.designservice.service.requirement.RequirementStatusService;
import com.m2z.tools.shared.controller.BaseController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/requirement-statuses")
public class RequirementStatusController
        extends BaseController<RequirementStatus, RequirementStatusDTO, Long> {
    private final RequirementStatusService service;

    public RequirementStatusController(RequirementStatusService service) {
        super(service);
        this.service = service;
    }
}
