package com.m2z.tools.designservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2z.tools.designservice.dto.diagram.AccessTypeDTO;
import com.m2z.tools.designservice.dto.diagram.ClassTypeDTO;
import com.m2z.tools.designservice.dto.diagram.RelationshipTypeDTO;
import com.m2z.tools.designservice.dto.requirement.RequirementPriorityDTO;
import com.m2z.tools.designservice.dto.requirement.RequirementRiskDTO;
import com.m2z.tools.designservice.dto.requirement.RequirementStatusDTO;
import com.m2z.tools.designservice.dto.requirement.RequirementTypeDTO;
import com.m2z.tools.designservice.model.meta.Meta;
import com.m2z.tools.designservice.repository.meta.MetaRepository;
import com.m2z.tools.designservice.service.diagram.AccessTypeService;
import com.m2z.tools.designservice.service.diagram.ClassTypeService;
import com.m2z.tools.designservice.service.diagram.RelationshipTypeService;
import com.m2z.tools.designservice.service.requirement.RequirementPriorityService;
import com.m2z.tools.designservice.service.requirement.RequirementRiskService;
import com.m2z.tools.designservice.service.requirement.RequirementStatusService;
import com.m2z.tools.designservice.service.requirement.RequirementTypeService;

import lombok.RequiredArgsConstructor;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AppStartupRunner implements ApplicationRunner {
    private final RequirementTypeService requirementTypeService;
    private final RequirementPriorityService requirementPriorityService;
    private final RequirementRiskService requirementRiskService;
    private final RequirementStatusService requirementStatusService;

    private final ClassTypeService classTypeService;

    private final AccessTypeService accessTypeService;

    private final RelationshipTypeService relationshipTypeService;

    private final MetaRepository metaRepository;

    private final List<String> requirementTypes = List.of("Functional", "Nonfunctional");
    private final List<String> requirementPriorities =
            List.of("Essential", "Very desirable", "Desirable", "Optional", "Undesirable");
    private final List<String> requirementRisks = List.of("High", "Medium", "Low");
    private final List<String> requirementStatuses = List.of("Draft", "Defined", "Confirmed");

    private final List<String> classTypes = List.of("class", "abstract", "interface");

    private final List<String> accessTypes = List.of("private", "protected", "public");

    private final List<String> relationshipTypes =
            List.of("implements", "extends", "association", "aggregation", "composition", "inner");

    @Override
    public void run(ApplicationArguments args) {
        if (requirementTypeService.findAll().isEmpty()) {
            requirementTypes.forEach(
                    type -> requirementTypeService.forceSave(new RequirementTypeDTO(type)));
        }

        if (requirementPriorityService.findAll().isEmpty()) {
            requirementPriorities.forEach(
                    priority ->
                            requirementPriorityService.forceSave(
                                    new RequirementPriorityDTO(priority)));
        }

        if (requirementRiskService.findAll().isEmpty()) {
            requirementRisks.forEach(
                    risk -> requirementRiskService.forceSave(new RequirementRiskDTO(risk)));
        }

        if (requirementStatusService.findAll().isEmpty()) {
            requirementStatuses.forEach(
                    status -> requirementStatusService.forceSave(new RequirementStatusDTO(status)));
        }

        if (classTypeService.findAll().isEmpty()) {
            classTypes.forEach(type -> classTypeService.forceSave(new ClassTypeDTO(type)));
        }

        if (accessTypeService.findAll().isEmpty()) {
            accessTypes.forEach(type -> accessTypeService.forceSave(new AccessTypeDTO(type)));
        }

        if (relationshipTypeService.findAll().isEmpty()) {
            relationshipTypes.forEach(
                    type -> relationshipTypeService.forceSave(new RelationshipTypeDTO(type)));
        }

        if (((List<Meta>) metaRepository.findAll()).isEmpty()) {
            loadMeta();
        }
    }

    private void loadMeta() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File("src/main/resources/database/meta.json");
            Meta[] metas = objectMapper.readValue(file, Meta[].class);
            for (Meta meta : metas) {
                meta.getHeaders().forEach(header -> header.setMeta(meta));
                meta.getChildren().forEach(child -> child.setMeta(meta));
                metaRepository.save(meta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
