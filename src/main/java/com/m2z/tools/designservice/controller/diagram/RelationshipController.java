package com.m2z.tools.designservice.controller.diagram;

import com.m2z.tools.designservice.controller.BaseController;
import com.m2z.tools.designservice.dto.diagram.RelationshipDTO;
import com.m2z.tools.designservice.model.diagram.Relationship;
import com.m2z.tools.designservice.service.diagram.RelationshipService;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/relationships")
public class RelationshipController extends BaseController<Relationship, RelationshipDTO, Long> {
    private final RelationshipService service;

    public RelationshipController(RelationshipService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<Page<RelationshipDTO>> getAllByProject(
            @ParameterObject Pageable pageable,
            @RequestParam(defaultValue = "") String search,
            @PathVariable String id) {
        return new ResponseEntity<>(service.findAllByProject(pageable, search, id), HttpStatus.OK);
    }

    @GetMapping("/class/{id}")
    public ResponseEntity<Page<RelationshipDTO>> getAllByClass(
            @ParameterObject Pageable pageable,
            @RequestParam(defaultValue = "") String search,
            @PathVariable String id) {
        return new ResponseEntity<>(service.findAllByClass(pageable, search, id), HttpStatus.OK);
    }
}
