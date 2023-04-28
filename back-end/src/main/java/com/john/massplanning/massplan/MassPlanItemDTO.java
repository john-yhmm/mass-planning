package com.john.massplanning.massplan;

import java.io.Serializable;

public record MassPlanItemDTO(
        Integer id,
        Byte serialNo,
        MassPlanItemType type,
        String name,
        Integer linkedId
) implements Serializable {
}
