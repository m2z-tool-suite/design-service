package com.m2z.tools.designservice.service.diagram;

import com.m2z.tools.designservice.dto.diagram.MethodDTO;
import com.m2z.tools.designservice.mapper.diagram.MethodMapper;
import com.m2z.tools.designservice.model.diagram.Method;
import com.m2z.tools.designservice.repository.diagram.MethodRepository;
import com.m2z.tools.designservice.service.BaseService;

import org.springframework.stereotype.Service;

@Service
public class MethodService extends BaseService<Method, MethodDTO, Long> {
    private final MethodRepository repository;
    private final MethodMapper mapper;

    public MethodService(MethodRepository repository, MethodMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
