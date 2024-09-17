package com.mitocode.controller;

import com.mitocode.dto.GenericResponse;
import com.mitocode.dto.CourseDTO;
import com.mitocode.model.Course;
import com.mitocode.service.ICourseService;
import com.mitocode.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    
    private final ICourseService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<GenericResponse<CourseDTO>> readAll() throws Exception{
        List<CourseDTO> list = mapperUtil.mapList(service.findAll(), CourseDTO.class);
        return ResponseEntity.ok(new GenericResponse<>(200, "success", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<CourseDTO>> readById(@PathVariable("id") Integer id) throws Exception{
        CourseDTO obj = mapperUtil.map(service.findById(id), CourseDTO.class);
        return ResponseEntity.ok(new GenericResponse<>(200, "success", Arrays.asList(obj)));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> save(@Valid @RequestBody CourseDTO dto) throws Exception{
        Course obj = service.save(mapperUtil.map(dto, Course.class));
        return new ResponseEntity<>(mapperUtil.map(obj, CourseDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@Valid @PathVariable("id") Integer id, @Valid @RequestBody CourseDTO dto) throws Exception{
        Course obj = service.update(id, mapperUtil.map(dto, Course.class));
        return new ResponseEntity<>(mapperUtil.map(obj, CourseDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
