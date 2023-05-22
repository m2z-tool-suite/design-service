package com.m2z.tools.designservice.service.diagram;

import com.m2z.tools.designservice.dto.diagram.RelationshipDTO;
import com.m2z.tools.designservice.mapper.diagram.RelationshipMapper;
import com.m2z.tools.designservice.model.diagram.Relationship;
import com.m2z.tools.designservice.repository.diagram.RelationshipRepository;
import com.m2z.tools.designservice.service.BaseService;

import org.springframework.stereotype.Service;

@Service
public class RelationshipService extends BaseService<Relationship, RelationshipDTO, Long> {
    private final RelationshipRepository repository;
    private final RelationshipMapper mapper;

    public RelationshipService(RelationshipRepository repository, RelationshipMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
