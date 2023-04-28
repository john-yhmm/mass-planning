package com.john.massplanning.mass;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record MassDTO(
        Integer id,
        String title,
        String subTitle,
        LocalDate date,
        LocalTime time,
        List<MassDetailDTO> massDetailList
) {
}
