package com.m2z.tools.designservice.service.diagram;

import com.m2z.tools.designservice.dto.diagram.PropertyDTO;
import com.m2z.tools.designservice.mapper.diagram.PropertyMapper;
import com.m2z.tools.designservice.model.diagram.Property;
import com.m2z.tools.designservice.repository.diagram.PropertyRepository;
import com.m2z.tools.designservice.service.BaseService;

import org.springframework.stereotype.Service;

@Service
public class PropertyService extends BaseService<Property, PropertyDTO, Long> {
    private final PropertyRepository repository;
    private final PropertyMapper mapper;

    public PropertyService(PropertyRepository repository, PropertyMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
