package com.m2z.tools.designservice.service.diagram;

import static com.m2z.tools.security.util.SecurityUtil.getProjects;

import com.m2z.tools.designservice.dto.diagram.ParameterDTO;
import com.m2z.tools.designservice.mapper.diagram.ParameterMapper;
import com.m2z.tools.designservice.model.diagram.Method;
import com.m2z.tools.designservice.model.diagram.Parameter;
import com.m2z.tools.designservice.repository.diagram.MethodRepository;
import com.m2z.tools.designservice.repository.diagram.ParameterRepository;
import com.m2z.tools.shared.exception.ForbiddenException;
import com.m2z.tools.shared.service.BaseService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ParameterService extends BaseService<Parameter, ParameterDTO, Long> {
    private final ParameterRepository repository;
    private final ParameterMapper mapper;

    private final MethodRepository methodRepository;

    public ParameterService(
            ParameterRepository repository,
            ParameterMapper mapper,
            MethodRepository methodRepository) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
        this.methodRepository = methodRepository;
    }

    public Page<ParameterDTO> findAllByProject(Pageable pageable, String search, String projectId) {
        HashMap<String, String> projects = getProjects();
        if (!projects.containsKey(projectId)) {
            throw new ForbiddenException("Not allowed to access this project's parameters");
        }
        return repository
                .findContainingByProject(pageable, "%" + search + "%", projectId)
                .map(mapper::toDTO);
    }

    public Page<ParameterDTO> findAllByMethod(Pageable pageable, String search, Long methodId) {
        HashMap<String, String> projects = getProjects();
        Method method = methodRepository.findById(methodId).orElse(null);
        if (method == null || !projects.containsKey(method.getClass_().getDiagram().getProject())) {
            throw new ForbiddenException("Not allowed to access this method's parameters");
        }
        return repository
                .findContainingByMethod(pageable, "%" + search + "%", methodId)
                .map(mapper::toDTO);
    }
}
