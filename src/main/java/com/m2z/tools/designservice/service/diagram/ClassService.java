package com.m2z.tools.designservice.service.diagram;

import com.m2z.tools.designservice.dto.diagram.ClassDTO;
import com.m2z.tools.designservice.exception.NotFoundException;
import com.m2z.tools.designservice.mapper.diagram.ClassMapper;
import com.m2z.tools.designservice.model.diagram.Class;
import com.m2z.tools.designservice.repository.diagram.ClassRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClassService {
    private final ClassRepository repository;
    private final ClassMapper mapper;

    public List<ClassDTO> findAll() {
        return mapper.toDTO((List<Class>) repository.findAll());
    }

    public Page<ClassDTO> findAll(Pageable pageable, String search) {
        return repository.findContaining(pageable, "%" + search + "%").map(mapper::toDTO);
    }

    public List<ClassDTO> findById(Set<String> ids) {
        boolean anyNotFound = ids.stream().anyMatch((id) -> !repository.existsById(id));
        if (anyNotFound) {
            throw new NotFoundException("ID not found");
        }
        return mapper.toDTO((List<Class>) repository.findAllById(ids));
    }

    @Transactional
    public ClassDTO save(ClassDTO DTO) {
        String id = DTO.getId();
        if (id != null && !repository.existsById(id)) {
            throw new NotFoundException("ID not found");
        }

        return this.forceSave(DTO);
    }

    @Transactional
    public ClassDTO forceSave(ClassDTO DTO) {
        Class model = mapper.toModel(DTO);
        return mapper.toDTO(repository.save(model));
    }

    @Transactional
    public void delete(Set<String> ids) {
        boolean anyNotFound = ids.stream().anyMatch((id) -> !repository.existsById(id));
        if (anyNotFound) {
            throw new NotFoundException("ID not found");
        }
        repository.softDeleteByIds(ids);
    }
}
