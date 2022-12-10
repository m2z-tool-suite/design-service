package com.m2z.tools.designservice.service;

import com.m2z.tools.designservice.dto.DiagramDTO;
import com.m2z.tools.designservice.mapper.DiagramMapper;
import com.m2z.tools.designservice.model.Diagram;
import com.m2z.tools.designservice.repository.DiagramRepository;
import org.springframework.stereotype.Service;

@Service
public class DiagramService extends BaseService<Diagram, DiagramDTO, Long> {
    private final DiagramRepository repository;
    private final DiagramMapper mapper;

    public DiagramService(DiagramRepository repository, DiagramMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
