package com.m2z.tools.designservice.service.requirement;

import com.m2z.tools.designservice.dto.requirement.RequirementStatusDTO;
import com.m2z.tools.designservice.mapper.requirement.RequirementStatusMapper;
import com.m2z.tools.designservice.model.requirement.RequirementStatus;
import com.m2z.tools.designservice.repository.requirement.RequirementStatusRepository;
import com.m2z.tools.shared.service.BaseService;

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
