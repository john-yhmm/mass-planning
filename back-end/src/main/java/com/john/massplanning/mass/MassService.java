package com.john.massplanning.mass;

import com.john.massplanning.common.PageDTO;
import com.john.massplanning.common.PageDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MassService {
    private final PageDTOMapper<Mass, MassDTO> pageDTOMapper = new PageDTOMapper<>();
    private final MassDTOMapper massDTOMapper = new MassDTOMapper();
    private final MassDetailDTOMapper massDetailDTOMapper = new MassDetailDTOMapper();

    @Autowired
    private MassRepository massRepository;

    @Autowired
    private MassDetailRepository massDetailRepository;

    @Transactional(rollbackFor = Exception.class)
    public void register(MassDTO massDTO) {
        Mass mass = new Mass();
        setMassPersistentFields(mass, massDTO);

        for (MassDetailDTO massDetailDTO : massDTO.massDetailList()) {
            MassDetail massDetail = new MassDetail();
            setMassDetailPersistentFields(massDetail, massDetailDTO);
            massDetail.setMass(mass);

            mass.getMassDetailList().add(massDetail);
        }
        massRepository.save(mass);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(MassDTO massDTO) {
        Mass mass = checkValidMass(massDTO.id());
        setMassPersistentFields(mass, massDTO);

        for (MassDetailDTO massDetailDTO : massDTO.massDetailList()) {
            MassDetail massDetail = checkValidMassDetail(massDetailDTO.id());
            setMassDetailPersistentFields(massDetail, massDetailDTO);
        }
        massRepository.save(mass);
    }

    public PageDTO<MassDTO> getPagedList() {
        Page<Mass> page = massRepository.findAll(Pageable.ofSize(10));
        List<Mass> massList = page.getContent();

        PageDTO<MassDTO> pageDTO = pageDTOMapper.apply(page);

        for (Mass mass : massList) {
            MassDTO massDTO = massDTOMapper.apply(mass);
            pageDTO.pagedList().add(massDTO);
        }
        return pageDTO;
    }

    public MassDTO getById(Integer id) {
        Mass mass = checkValidMass(id);
        MassDTO massDTO = massDTOMapper.apply(mass);
        massDTO.massDetailList().addAll(mass.getMassDetailList().stream().map(massDetailDTOMapper).toList());
        return massDTO;
    }

    private void setMassPersistentFields(Mass mass, MassDTO dto) {
        mass.setTitle(dto.title());
        mass.setSubTitle(dto.subTitle());
        mass.setDate(dto.date());
        mass.setTime(dto.time());
    }

    private void setMassDetailPersistentFields(MassDetail massDetail, MassDetailDTO dto) {
        massDetail.setSerialNo(dto.serialNo());
        massDetail.setType(dto.type());
        massDetail.setName(dto.name());
        massDetail.setLinkedId(dto.linkedId());
    }

    private Mass checkValidMass(Integer massId) {
        return massRepository.findById(massId).orElseThrow(() -> new IllegalArgumentException("Invalid Mass Id"));
    }

    private MassDetail checkValidMassDetail(Integer massDetailId) {
        return massDetailRepository.findById(massDetailId).orElseThrow(() -> new IllegalArgumentException("Invalid Mass Detail Id"));
    }

}
