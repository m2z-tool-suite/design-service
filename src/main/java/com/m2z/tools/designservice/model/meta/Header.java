package com.m2z.tools.designservice.model.meta;

import jakarta.persistence.*;

import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Header {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private String value;

    @Column(nullable = false)
    private boolean sortable;

    @ManyToOne(optional = false)
    private Meta meta;
}
