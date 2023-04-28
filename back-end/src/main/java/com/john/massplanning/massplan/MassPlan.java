package com.john.massplanning.massplan;

import com.john.massplanning.common.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "mass_plan")
public class MassPlan extends AuditableEntity {

    @Serial
    private static final long serialVersionUID = -5092962056752246780L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "sub_title")
    private String subTitle;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @OneToMany(mappedBy = "massPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MassPlanItem> massPlanItemList = new ArrayList<>();

}
