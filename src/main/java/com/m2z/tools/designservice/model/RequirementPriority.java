package com.m2z.tools.designservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RequirementPriority extends BaseEntity<Long> {
    @Column(nullable = false)
    private String title;

    @OneToMany(mappedBy = "priority")
    private Set<Requirement> requirements = new HashSet<>();
}
