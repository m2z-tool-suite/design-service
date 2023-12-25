package com.m2z.tools.designservice.controller.diagram;

import com.m2z.tools.designservice.dto.diagram.PropertyDTO;
import com.m2z.tools.designservice.model.diagram.Property;
import com.m2z.tools.designservice.service.diagram.PropertyService;
import com.m2z.tools.shared.controller.BaseController;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/properties")
public class PropertyController extends BaseController<Property, PropertyDTO, Long> {
    private final PropertyService service;

    public PropertyController(PropertyService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<Page<PropertyDTO>> getAllByProject(
            @ParameterObject Pageable pageable,
            @RequestParam(defaultValue = "") String search,
            @PathVariable String id) {
        return new ResponseEntity<>(service.findAllByProject(pageable, search, id), HttpStatus.OK);
    }

    @GetMapping("/class/{id}")
    public ResponseEntity<Page<PropertyDTO>> getAllByClass(
            @ParameterObject Pageable pageable,
            @RequestParam(defaultValue = "") String search,
            @PathVariable String id) {
        return new ResponseEntity<>(service.findAllByClass(pageable, search, id), HttpStatus.OK);
    }
}
