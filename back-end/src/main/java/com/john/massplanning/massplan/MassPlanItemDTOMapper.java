package com.john.massplanning.massplan;

import java.util.function.Function;

public class MassPlanItemDTOMapper implements Function<MassPlanItem, MassPlanItemDTO> {
    @Override
    public MassPlanItemDTO apply(MassPlanItem entity) {
        return new MassPlanItemDTO(
                entity.getId(),
                entity.getSerialNo(),
                entity.getType(),
                entity.getName(),
                entity.getLinkedId()
        );
    }
}
