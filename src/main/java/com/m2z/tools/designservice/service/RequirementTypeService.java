package com.m2z.tools.designservice.service;

import com.m2z.tools.designservice.dto.RequirementTypeDTO;
import com.m2z.tools.designservice.mapper.RequirementTypeMapper;
import com.m2z.tools.designservice.model.RequirementType;
import com.m2z.tools.designservice.repository.RequirementTypeRepository;

import org.springframework.stereotype.Service;

@Service
public class RequirementTypeService extends BaseService<RequirementType, RequirementTypeDTO, Long> {
    private final RequirementTypeRepository repository;
    private final RequirementTypeMapper mapper;

    public RequirementTypeService(
            RequirementTypeRepository repository, RequirementTypeMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
