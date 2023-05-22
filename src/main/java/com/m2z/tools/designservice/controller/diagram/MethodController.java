package com.m2z.tools.designservice.controller.diagram;

import com.m2z.tools.designservice.controller.BaseController;
import com.m2z.tools.designservice.dto.diagram.MethodDTO;
import com.m2z.tools.designservice.model.diagram.Method;
import com.m2z.tools.designservice.service.diagram.MethodService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/methods")
public class MethodController extends BaseController<Method, MethodDTO, Long> {
    private final MethodService service;

    public MethodController(MethodService service) {
        super(service);
        this.service = service;
    }
}
