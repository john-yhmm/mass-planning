package com.john.massplanning.mass;

import java.util.function.Function;

public class MassDetailDTOMapper implements Function<MassDetail, MassDetailDTO> {
    @Override
    public MassDetailDTO apply(MassDetail entity) {
        return new MassDetailDTO(
                entity.getId(),
                entity.getSerialNo(),
                entity.getType(),
                entity.getName(),
                entity.getLinkedId()
        );
    }
}
