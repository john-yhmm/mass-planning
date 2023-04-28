package com.john.massplanning.massitem;

import jakarta.persistence.*;

public class MassItemDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "serial_no")
    private Byte serialNo;

    @Column(name = "value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "mass_item_id")
    private MassItem massItem;
}
