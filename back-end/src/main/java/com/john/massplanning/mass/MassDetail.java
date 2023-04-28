package com.john.massplanning.mass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "mass_detail")
public class MassDetail implements Serializable {

    @Serial
    private static final long serialVersionUID = 7986055042251640128L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "serial_no")
    private Byte serialNo;

    @Column(name = "type")
    private MassDetailType type;

    @Column(name = "name")
    private String name;

    @Column(name = "linked_id")
    private Integer linkedId;

    @ManyToOne
    @JoinColumn(name = "mass_id")
    private Mass mass;

}
