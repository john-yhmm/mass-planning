package com.john.massplanning.massplan;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "mass_plan_item")
public class MassPlanItem implements Serializable {

    @Serial
    private static final long serialVersionUID = 7986055042251640128L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "serial_no")
    private Byte serialNo;

    @Column(name = "type")
    private MassPlanItemType type;

    @Column(name = "name")
    private String name;

    @Column(name = "linked_id")
    private Integer linkedId;

    @ManyToOne
    @JoinColumn(name = "mass_plan_id")
    private MassPlan massPlan;

}
