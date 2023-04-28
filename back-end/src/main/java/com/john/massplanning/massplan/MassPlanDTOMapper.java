package com.john.massplanning.massplan;

import java.util.ArrayList;
import java.util.function.Function;

public class MassPlanDTOMapper implements Function<MassPlan, MassPlanDTO> {
    @Override
    public MassPlanDTO apply(MassPlan entity) {
        return new MassPlanDTO(
                entity.getId(),
                entity.getTitle(),
                entity.getSubTitle(),
                entity.getDate(),
                entity.getTime(),
                new ArrayList<>()
        );
    }
}
