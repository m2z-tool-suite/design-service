package com.m2z.tools.designservice.model.meta;

import jakarta.persistence.*;

import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "key_", nullable = false)
    private String key;

    @Column(name = "name_", nullable = false)
    private String name;

    @Column(nullable = false)
    private String dataSource;

    @ManyToOne(optional = false)
    private Meta meta;
}
