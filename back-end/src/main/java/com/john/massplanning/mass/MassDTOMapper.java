package com.john.massplanning.mass;

import java.util.ArrayList;
import java.util.function.Function;

public class MassDTOMapper implements Function<Mass, MassDTO> {
    @Override
    public MassDTO apply(Mass entity) {
        return new MassDTO(
                entity.getId(),
                entity.getTitle(),
                entity.getSubTitle(),
                entity.getDate(),
                entity.getTime(),
                new ArrayList<>()
        );
    }
}
