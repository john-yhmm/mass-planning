package com.john.massplanning.massitem;

import com.john.massplanning.common.AuditableEntity;
import jakarta.persistence.*;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

public class MassItem extends AuditableEntity {

    @Serial
    private static final long serialVersionUID = -2992647193177147739L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "notes")
    private String notes;

    @OneToMany(mappedBy = "massItem", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<MassItemDetail> massItemDetailList = new ArrayList<>();
}
