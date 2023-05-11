package com.m2z.tools.designservice.service;

import com.m2z.tools.designservice.dto.RequirementRiskDTO;
import com.m2z.tools.designservice.mapper.RequirementRiskMapper;
import com.m2z.tools.designservice.model.RequirementRisk;
import com.m2z.tools.designservice.repository.RequirementRiskRepository;

import org.springframework.stereotype.Service;

@Service
public class RequirementRiskService extends BaseService<RequirementRisk, RequirementRiskDTO, Long> {
    private final RequirementRiskRepository repository;
    private final RequirementRiskMapper mapper;

    public RequirementRiskService(
            RequirementRiskRepository repository, RequirementRiskMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
