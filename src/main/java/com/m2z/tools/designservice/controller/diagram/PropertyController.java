package com.m2z.tools.designservice.controller.diagram;

import com.m2z.tools.designservice.controller.BaseController;
import com.m2z.tools.designservice.dto.diagram.PropertyDTO;
import com.m2z.tools.designservice.model.diagram.Property;
import com.m2z.tools.designservice.service.diagram.PropertyService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/properties")
public class PropertyController extends BaseController<Property, PropertyDTO, Long> {
    private final PropertyService service;

    public PropertyController(PropertyService service) {
        super(service);
        this.service = service;
    }
}
