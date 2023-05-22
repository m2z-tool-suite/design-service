package com.m2z.tools.designservice.controller.diagram;

import com.m2z.tools.designservice.controller.BaseController;
import com.m2z.tools.designservice.dto.diagram.ParameterDTO;
import com.m2z.tools.designservice.model.diagram.Parameter;
import com.m2z.tools.designservice.service.diagram.ParameterService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/parameters")
public class ParameterController extends BaseController<Parameter, ParameterDTO, Long> {
    private final ParameterService service;

    public ParameterController(ParameterService service) {
        super(service);
        this.service = service;
    }
}
