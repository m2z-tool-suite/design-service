package com.m2z.tools.designservice.service.meta;

import com.m2z.tools.designservice.dto.meta.MetaDTO;
import com.m2z.tools.designservice.mapper.meta.MetaMapper;
import com.m2z.tools.designservice.model.meta.Meta;
import com.m2z.tools.designservice.repository.meta.MetaRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MetaService {
    private final MetaRepository repository;
    private final MetaMapper mapper;

    public List<MetaDTO> findAll() {
        return mapper.toDTO((List<Meta>) repository.findAll());
    }
}
