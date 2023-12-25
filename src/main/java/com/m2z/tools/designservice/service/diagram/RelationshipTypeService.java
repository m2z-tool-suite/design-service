package com.m2z.tools.designservice.service.diagram;

import com.m2z.tools.designservice.dto.diagram.RelationshipTypeDTO;
import com.m2z.tools.designservice.mapper.diagram.RelationshipTypeMapper;
import com.m2z.tools.designservice.model.diagram.RelationshipType;
import com.m2z.tools.designservice.repository.diagram.RelationshipTypeRepository;
import com.m2z.tools.shared.service.BaseService;

import org.springframework.stereotype.Service;

@Service
public class RelationshipTypeService
        extends BaseService<RelationshipType, RelationshipTypeDTO, Long> {
    private final RelationshipTypeRepository repository;
    private final RelationshipTypeMapper mapper;

    public RelationshipTypeService(
            RelationshipTypeRepository repository, RelationshipTypeMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
