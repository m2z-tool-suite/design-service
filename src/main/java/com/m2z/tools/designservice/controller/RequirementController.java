package com.m2z.tools.designservice.controller;

import com.m2z.tools.designservice.dto.RequirementDTO;
import com.m2z.tools.designservice.model.Requirement;
import com.m2z.tools.designservice.service.RequirementService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/requirements")
public class RequirementController extends BaseController<Requirement, RequirementDTO, Long> {
    private final RequirementService service;

    public RequirementController(RequirementService service) {
        super(service);
        this.service = service;
    }
}
