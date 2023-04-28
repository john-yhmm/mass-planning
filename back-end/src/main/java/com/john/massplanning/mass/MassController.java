package com.john.massplanning.mass;

import com.john.massplanning.common.MessageConst;
import com.john.massplanning.common.PageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mass")
public class MassController {
    @Autowired
    private MassService massService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody MassDTO massDTO) {
        massService.register(massDTO);
        return new ResponseEntity<>(MessageConst.REGISTER_SUCCESS, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody MassDTO massDTO) {
        massService.update(massDTO);
        return new ResponseEntity<>(MessageConst.UPDATE_SUCCESS, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getPagedList() {
        PageDTO<MassDTO> pageDTO = massService.getPagedList();
        return new ResponseEntity<>(pageDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        MassDTO massDTO = massService.getById(id);
        return new ResponseEntity<>(massDTO, HttpStatus.OK);
    }
}
