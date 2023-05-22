package com.m2z.tools.designservice.service.requirement;

import com.m2z.tools.designservice.dto.requirement.RequirementTypeDTO;
import com.m2z.tools.designservice.mapper.requirement.RequirementTypeMapper;
import com.m2z.tools.designservice.model.requirement.RequirementType;
import com.m2z.tools.designservice.repository.requirement.RequirementTypeRepository;
import com.m2z.tools.designservice.service.BaseService;

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
