package com.m2z.tools.designservice.service.diagram;

import com.m2z.tools.designservice.dto.diagram.ParameterDTO;
import com.m2z.tools.designservice.mapper.diagram.ParameterMapper;
import com.m2z.tools.designservice.model.diagram.Parameter;
import com.m2z.tools.designservice.repository.diagram.ParameterRepository;
import com.m2z.tools.designservice.service.BaseService;

import org.springframework.stereotype.Service;

@Service
public class ParameterService extends BaseService<Parameter, ParameterDTO, Long> {
    private final ParameterRepository repository;
    private final ParameterMapper mapper;

    public ParameterService(ParameterRepository repository, ParameterMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
