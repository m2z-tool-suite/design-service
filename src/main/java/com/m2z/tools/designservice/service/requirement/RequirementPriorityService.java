package com.m2z.tools.designservice.service.requirement;

import com.m2z.tools.designservice.dto.requirement.RequirementPriorityDTO;
import com.m2z.tools.designservice.mapper.requirement.RequirementPriorityMapper;
import com.m2z.tools.designservice.model.requirement.RequirementPriority;
import com.m2z.tools.designservice.repository.requirement.RequirementPriorityRepository;
import com.m2z.tools.designservice.service.BaseService;

import org.springframework.stereotype.Service;

@Service
public class RequirementPriorityService
        extends BaseService<RequirementPriority, RequirementPriorityDTO, Long> {
    private final RequirementPriorityRepository repository;
    private final RequirementPriorityMapper mapper;

    public RequirementPriorityService(
            RequirementPriorityRepository repository, RequirementPriorityMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
