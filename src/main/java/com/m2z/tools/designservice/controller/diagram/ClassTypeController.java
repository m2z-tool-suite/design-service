package com.m2z.tools.designservice.controller.diagram;

import com.m2z.tools.designservice.controller.BaseController;
import com.m2z.tools.designservice.dto.diagram.ClassTypeDTO;
import com.m2z.tools.designservice.model.diagram.ClassType;
import com.m2z.tools.designservice.service.diagram.ClassTypeService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/class-types")
public class ClassTypeController extends BaseController<ClassType, ClassTypeDTO, Long> {
    private final ClassTypeService service;

    public ClassTypeController(ClassTypeService service) {
        super(service);
        this.service = service;
    }
}
