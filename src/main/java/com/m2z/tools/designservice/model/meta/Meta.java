package com.m2z.tools.designservice.model.meta;


import jakarta.persistence.*;

import lombok.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Meta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "key_", nullable = false)
    private String key;

    @Column(name = "name_", nullable = false)
    private String name;

    @Column(nullable = false)
    private String dataSource;

    @OneToMany(mappedBy = "meta", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Header> headers = new ArrayList<>();

    @OneToMany(mappedBy = "meta", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Child> children = new ArrayList<>();
}
