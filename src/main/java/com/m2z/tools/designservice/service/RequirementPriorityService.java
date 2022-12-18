package com.m2z.tools.designservice.service;

import com.m2z.tools.designservice.dto.RequirementPriorityDTO;
import com.m2z.tools.designservice.mapper.RequirementPriorityMapper;
import com.m2z.tools.designservice.model.RequirementPriority;
import com.m2z.tools.designservice.repository.RequirementPriorityRepository;
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
