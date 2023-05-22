package com.m2z.tools.designservice.controller.diagram;

import com.m2z.tools.designservice.controller.BaseController;
import com.m2z.tools.designservice.dto.diagram.RelationshipTypeDTO;
import com.m2z.tools.designservice.model.diagram.RelationshipType;
import com.m2z.tools.designservice.service.diagram.RelationshipTypeService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/relationship-types")
public class RelationshipTypeController
        extends BaseController<RelationshipType, RelationshipTypeDTO, Long> {
    private final RelationshipTypeService service;

    public RelationshipTypeController(RelationshipTypeService service) {
        super(service);
        this.service = service;
    }
}
