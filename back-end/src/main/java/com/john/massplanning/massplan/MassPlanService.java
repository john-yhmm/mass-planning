package com.john.massplanning.massplan;

import com.john.massplanning.common.PageDTO;
import com.john.massplanning.common.PageDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MassPlanService {
    private final PageDTOMapper<MassPlan, MassPlanDTO> pageDTOMapper = new PageDTOMapper<>();
    private final MassPlanDTOMapper massPlanDTOMapper = new MassPlanDTOMapper();
    private final MassPlanItemDTOMapper massPlanItemDTOMapper = new MassPlanItemDTOMapper();

    @Autowired
    private MassPlanRepository massPlanRepository;

    @Autowired
    private MassPlanItemRepository massPlanItemRepository;

    @Transactional(rollbackFor = Exception.class)
    public void register(MassPlanDTO massPlanDTO) {
        MassPlan massPlan = new MassPlan();
        setMassPlanPersistentFields(massPlan, massPlanDTO);

        for (MassPlanItemDTO massPlanItemDTO : massPlanDTO.massPlanItemList()) {
            MassPlanItem massPlanItem = new MassPlanItem();
            setMassPlanItemPersistentFields(massPlanItem, massPlanItemDTO);
            massPlanItem.setMassPlan(massPlan);

            massPlan.getMassPlanItemList().add(massPlanItem);
        }
        massPlanRepository.save(massPlan);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(MassPlanDTO massPlanDTO) {
        MassPlan massPlan = checkValidMassPlan(massPlanDTO.id());
        setMassPlanPersistentFields(massPlan, massPlanDTO);

        for (MassPlanItemDTO massPlanItemDTO : massPlanDTO.massPlanItemList()) {
            MassPlanItem massPlanItem = checkValidMassPlanItem(massPlanItemDTO.id());
            setMassPlanItemPersistentFields(massPlanItem, massPlanItemDTO);
        }
        massPlanRepository.save(massPlan);
    }

    public PageDTO<MassPlanDTO> getPagedList() {
        Page<MassPlan> page = massPlanRepository.findAll(Pageable.ofSize(10));
        List<MassPlan> massPlanList = page.getContent();

        PageDTO<MassPlanDTO> pageDTO = pageDTOMapper.apply(page);

        for (MassPlan massPlan : massPlanList) {
            MassPlanDTO massPlanDTO = massPlanDTOMapper.apply(massPlan);
            pageDTO.pagedList().add(massPlanDTO);
        }
        return pageDTO;
    }

    public MassPlanDTO getById(Integer id) {
        MassPlan massPlan = checkValidMassPlan(id);
        MassPlanDTO massPlanDTO = massPlanDTOMapper.apply(massPlan);
        massPlanDTO.massPlanItemList().addAll(
                massPlan.getMassPlanItemList()
                        .stream()
                        .map(massPlanItemDTOMapper)
                        .toList());
        return massPlanDTO;
    }

    private void setMassPlanPersistentFields(MassPlan massPlan, MassPlanDTO dto) {
        massPlan.setTitle(dto.title());
        massPlan.setSubTitle(dto.subTitle());
        massPlan.setDate(dto.date());
        massPlan.setTime(dto.time());
    }

    private void setMassPlanItemPersistentFields(MassPlanItem massPlanItem, MassPlanItemDTO dto) {
        massPlanItem.setSerialNo(dto.serialNo());
        massPlanItem.setType(dto.type());
        massPlanItem.setName(dto.name());
        massPlanItem.setLinkedId(dto.linkedId());
    }

    private MassPlan checkValidMassPlan(Integer massPlanId) {
        return massPlanRepository.findById(massPlanId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Mass Plan Id"));
    }

    private MassPlanItem checkValidMassPlanItem(Integer massPlanItemId) {
        return massPlanItemRepository.findById(massPlanItemId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Mass Plan Item Id"));
    }

}
