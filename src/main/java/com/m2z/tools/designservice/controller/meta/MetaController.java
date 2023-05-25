package com.m2z.tools.designservice.controller.meta;

import com.m2z.tools.designservice.dto.meta.MetaDTO;
import com.m2z.tools.designservice.service.meta.MetaService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meta")
@RequiredArgsConstructor
public class MetaController {
    private final MetaService service;

    @GetMapping
    public ResponseEntity<List<MetaDTO>> getAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
}
