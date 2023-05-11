package com.m2z.tools.designservice.controller;

import com.m2z.tools.designservice.dto.RequirementDTO;
import com.m2z.tools.designservice.model.Requirement;
import com.m2z.tools.designservice.service.RequirementService;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/requirements")
public class RequirementController extends BaseController<Requirement, RequirementDTO, Long> {
    private final RequirementService service;

    public RequirementController(RequirementService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/project")
    public ResponseEntity<Page<RequirementDTO>> getAllByProject(
            @ParameterObject Pageable pageable,
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "") String project) {
        return new ResponseEntity<>(
                service.findAllByProject(pageable, search, project), HttpStatus.OK);
    }
}
