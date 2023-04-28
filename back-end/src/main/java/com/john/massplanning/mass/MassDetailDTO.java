package com.john.massplanning.mass;

import java.io.Serializable;

public record MassDetailDTO(
        Integer id,
        Byte serialNo,
        MassDetailType type,
        String name,
        Integer linkedId
) implements Serializable {
}
