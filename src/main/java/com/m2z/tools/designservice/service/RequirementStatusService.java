package com.m2z.tools.designservice.service;

import com.m2z.tools.designservice.dto.RequirementStatusDTO;
import com.m2z.tools.designservice.mapper.RequirementStatusMapper;
import com.m2z.tools.designservice.model.RequirementStatus;
import com.m2z.tools.designservice.repository.RequirementStatusRepository;

import org.springframework.stereotype.Service;

@Service
public class RequirementStatusService
        extends BaseService<RequirementStatus, RequirementStatusDTO, Long> {
    private final RequirementStatusRepository repository;
    private final RequirementStatusMapper mapper;

    public RequirementStatusService(
            RequirementStatusRepository repository, RequirementStatusMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
