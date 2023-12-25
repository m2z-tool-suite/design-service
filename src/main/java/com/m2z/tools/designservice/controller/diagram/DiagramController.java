package com.m2z.tools.designservice.controller.diagram;

import com.m2z.tools.designservice.dto.diagram.DiagramDTO;
import com.m2z.tools.designservice.model.diagram.Diagram;
import com.m2z.tools.designservice.service.diagram.DiagramService;
import com.m2z.tools.shared.controller.BaseController;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/diagrams")
public class DiagramController extends BaseController<Diagram, DiagramDTO, Long> {
    private final DiagramService service;

    public DiagramController(DiagramService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<Page<DiagramDTO>> getAllByProject(
            @ParameterObject Pageable pageable,
            @RequestParam(defaultValue = "") String search,
            @PathVariable String id) {
        return new ResponseEntity<>(service.findAllByProject(pageable, search, id), HttpStatus.OK);
    }
}
