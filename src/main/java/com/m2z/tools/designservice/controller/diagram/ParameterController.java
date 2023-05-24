package com.m2z.tools.designservice.controller.diagram;

import com.m2z.tools.designservice.controller.BaseController;
import com.m2z.tools.designservice.dto.diagram.ParameterDTO;
import com.m2z.tools.designservice.model.diagram.Parameter;
import com.m2z.tools.designservice.service.diagram.ParameterService;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parameters")
public class ParameterController extends BaseController<Parameter, ParameterDTO, Long> {
    private final ParameterService service;

    public ParameterController(ParameterService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<Page<ParameterDTO>> getAllByProject(
            @ParameterObject Pageable pageable,
            @RequestParam(defaultValue = "") String search,
            @PathVariable String id) {
        return new ResponseEntity<>(service.findAllByProject(pageable, search, id), HttpStatus.OK);
    }

    @GetMapping("/method/{id}")
    public ResponseEntity<Page<ParameterDTO>> getAllByMethod(
            @ParameterObject Pageable pageable,
            @RequestParam(defaultValue = "") String search,
            @PathVariable Long id) {
        return new ResponseEntity<>(service.findAllByMethod(pageable, search, id), HttpStatus.OK);
    }
}
