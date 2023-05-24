package com.m2z.tools.designservice.model.diagram;

import com.m2z.tools.designservice.model.BaseEntity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccessType extends BaseEntity<Long> {
    @Column(name = "name_", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "accessType", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Property> properties;

    @OneToMany(mappedBy = "accessType", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Method> methods;
}
