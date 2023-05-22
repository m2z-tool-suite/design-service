package com.m2z.tools.designservice.service.diagram;

import com.m2z.tools.designservice.dto.diagram.ClassTypeDTO;
import com.m2z.tools.designservice.mapper.diagram.ClassTypeMapper;
import com.m2z.tools.designservice.model.diagram.ClassType;
import com.m2z.tools.designservice.repository.diagram.ClassTypeRepository;
import com.m2z.tools.designservice.service.BaseService;

import org.springframework.stereotype.Service;

@Service
public class ClassTypeService extends BaseService<ClassType, ClassTypeDTO, Long> {
    private final ClassTypeRepository repository;
    private final ClassTypeMapper mapper;

    public ClassTypeService(ClassTypeRepository repository, ClassTypeMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
