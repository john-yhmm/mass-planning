package com.john.massplanning.massplan;

import com.john.massplanning.common.MessageConst;
import com.john.massplanning.common.PageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mass-plan")
public class MassPlanController {
    @Autowired
    private MassPlanService massPlanService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody MassPlanDTO massPlanDTO) {
        massPlanService.register(massPlanDTO);
        return new ResponseEntity<>(MessageConst.REGISTER_SUCCESS, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody MassPlanDTO massPlanDTO) {
        massPlanService.update(massPlanDTO);
        return new ResponseEntity<>(MessageConst.UPDATE_SUCCESS, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getPagedList() {
        PageDTO<MassPlanDTO> pageDTO = massPlanService.getPagedList();
        return new ResponseEntity<>(pageDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        MassPlanDTO massPlanDTO = massPlanService.getById(id);
        return new ResponseEntity<>(massPlanDTO, HttpStatus.OK);
    }
}
