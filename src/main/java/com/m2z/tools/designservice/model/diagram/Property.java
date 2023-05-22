package com.m2z.tools.designservice.model.diagram;

import com.m2z.tools.designservice.model.BaseEntity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Property extends BaseEntity<Long> {
    @ManyToOne(optional = false)
    private AccessType accessType;

    @Column(name = "name_", nullable = false)
    private String name;

    @Column(name = "type_", nullable = false)
    private String type;

    @ManyToOne(optional = false)
    @JoinColumn(name = "class_id")
    private Class class_;
}
