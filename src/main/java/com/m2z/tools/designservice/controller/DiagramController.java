package com.m2z.tools.designservice.controller;

import com.m2z.tools.designservice.dto.DiagramDTO;
import com.m2z.tools.designservice.model.Diagram;
import com.m2z.tools.designservice.service.DiagramService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diagrams")
public class DiagramController extends BaseController<Diagram, DiagramDTO, Long> {
    private final DiagramService service;

    public DiagramController(DiagramService service) {
        super(service);
        this.service = service;
    }
}
