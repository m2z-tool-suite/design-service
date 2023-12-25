package com.m2z.tools.designservice.service.diagram;

import com.m2z.tools.designservice.dto.diagram.AccessTypeDTO;
import com.m2z.tools.designservice.mapper.diagram.AccessTypeMapper;
import com.m2z.tools.designservice.model.diagram.AccessType;
import com.m2z.tools.designservice.repository.diagram.AccessTypeRepository;
import com.m2z.tools.shared.service.BaseService;

import org.springframework.stereotype.Service;

@Service
public class AccessTypeService extends BaseService<AccessType, AccessTypeDTO, Long> {
    private final AccessTypeRepository repository;
    private final AccessTypeMapper mapper;

    public AccessTypeService(AccessTypeRepository repository, AccessTypeMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
