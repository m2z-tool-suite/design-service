package com.m2z.tools.designservice.controller;

import com.m2z.tools.designservice.dto.RequirementStatusDTO;
import com.m2z.tools.designservice.model.RequirementStatus;
import com.m2z.tools.designservice.service.RequirementStatusService;
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
