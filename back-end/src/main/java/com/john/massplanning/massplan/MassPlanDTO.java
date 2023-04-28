package com.john.massplanning.massplan;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record MassPlanDTO(
        Integer id,
        String title,
        String subTitle,
        LocalDate date,
        LocalTime time,
        List<MassPlanItemDTO> massPlanItemList
) implements Serializable {
}
