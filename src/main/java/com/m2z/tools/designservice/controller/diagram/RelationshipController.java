package com.m2z.tools.designservice.controller.diagram;

import com.m2z.tools.designservice.controller.BaseController;
import com.m2z.tools.designservice.dto.diagram.RelationshipDTO;
import com.m2z.tools.designservice.model.diagram.Relationship;
import com.m2z.tools.designservice.service.diagram.RelationshipService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/relationships")
public class RelationshipController extends BaseController<Relationship, RelationshipDTO, Long> {
    private final RelationshipService service;

    public RelationshipController(RelationshipService service) {
        super(service);
        this.service = service;
    }
}
