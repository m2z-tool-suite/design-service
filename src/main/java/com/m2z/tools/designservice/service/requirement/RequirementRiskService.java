package com.m2z.tools.designservice.service.requirement;

import com.m2z.tools.designservice.dto.requirement.RequirementRiskDTO;
import com.m2z.tools.designservice.mapper.requirement.RequirementRiskMapper;
import com.m2z.tools.designservice.model.requirement.RequirementRisk;
import com.m2z.tools.designservice.repository.requirement.RequirementRiskRepository;
import com.m2z.tools.designservice.service.BaseService;

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
