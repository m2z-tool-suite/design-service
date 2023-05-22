package com.m2z.tools.designservice.controller.diagram;

import com.m2z.tools.designservice.controller.BaseController;
import com.m2z.tools.designservice.dto.diagram.AccessTypeDTO;
import com.m2z.tools.designservice.model.diagram.AccessType;
import com.m2z.tools.designservice.service.diagram.AccessTypeService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/access-types")
public class AccessTypeController extends BaseController<AccessType, AccessTypeDTO, Long> {
    private final AccessTypeService service;

    public AccessTypeController(AccessTypeService service) {
        super(service);
        this.service = service;
    }
}
