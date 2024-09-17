package com.mitocode.controller;

import com.mitocode.dto.EnrollDTO;
import com.mitocode.dto.GenericResponse;
import com.mitocode.model.Enroll;
import com.mitocode.service.IEnrollService;
import com.mitocode.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollController {

    private final IEnrollService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<GenericResponse<EnrollDTO>> readAll() throws Exception{
        List<EnrollDTO> list = mapperUtil.mapList(service.findAll(), EnrollDTO.class);
        return ResponseEntity.ok(new GenericResponse<>(200, "success", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<EnrollDTO>> readById(@PathVariable("id") Integer id) throws Exception{
        EnrollDTO obj = mapperUtil.map(service.findById(id), EnrollDTO.class);
        return ResponseEntity.ok(new GenericResponse<>(200, "success", Arrays.asList(obj)));
    }

    @PostMapping
    public ResponseEntity<EnrollDTO> save(@Valid @RequestBody EnrollDTO dto) throws Exception{
        Enroll obj = service.save(mapperUtil.map(dto, Enroll.class));
        return new ResponseEntity<>(mapperUtil.map(obj, EnrollDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollDTO> update(@Valid @PathVariable("id") Integer id, @Valid @RequestBody EnrollDTO dto) throws Exception{
        Enroll obj = service.update(id, mapperUtil.map(dto, Enroll.class));
        return new ResponseEntity<>(mapperUtil.map(obj, EnrollDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/studentsByCourse")
    public ResponseEntity<Map<String, List<String>>> getStudentsByCourse(){
        Map<String, List<String>> map = service.getStudentsEnrolledByCourse();
        return ResponseEntity.ok(map);
    }

}
