package com.m2z.tools.designservice.service;

import com.m2z.tools.designservice.dto.RequirementDTO;
import com.m2z.tools.designservice.mapper.RequirementMapper;
import com.m2z.tools.designservice.model.Requirement;
import com.m2z.tools.designservice.repository.RequirementRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RequirementService extends BaseService<Requirement, RequirementDTO, Long> {
    private final RequirementRepository repository;
    private final RequirementMapper mapper;

    public RequirementService(RequirementRepository repository, RequirementMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    public Page<RequirementDTO> findAllByProject(Pageable pageable, String search, String project) {
        return repository
                .findContainingByProject(pageable, "%" + search + "%", project)
                .map(mapper::toDTO);
    }
}
