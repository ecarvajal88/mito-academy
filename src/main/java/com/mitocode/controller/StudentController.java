package com.mitocode.controller;

import com.mitocode.dto.GenericResponse;
import com.mitocode.dto.StudentDTO;
import com.mitocode.model.Student;
import com.mitocode.service.IStudentService;
import com.mitocode.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final IStudentService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<GenericResponse<StudentDTO>> readAll() throws Exception{
        List<StudentDTO> list = mapperUtil.mapList(service.findAll(), StudentDTO.class);
        return ResponseEntity.ok(new GenericResponse<>(200, "success", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<StudentDTO>> readById(@PathVariable("id") Integer id) throws Exception{
        StudentDTO obj = mapperUtil.map(service.findById(id), StudentDTO.class);
        return ResponseEntity.ok(new GenericResponse<>(200, "success", Arrays.asList(obj)));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> save(@Valid @RequestBody StudentDTO dto) throws Exception{
        Student obj = service.save(mapperUtil.map(dto, Student.class));
        return new ResponseEntity<>(mapperUtil.map(obj, StudentDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@Valid @PathVariable("id") Integer id, @Valid @RequestBody StudentDTO dto) throws Exception{
        Student obj = service.update(id, mapperUtil.map(dto, Student.class));
        return new ResponseEntity<>(mapperUtil.map(obj, StudentDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/orderedByAge")
    public ResponseEntity<GenericResponse<StudentDTO>> getStudentsOrderedByAge() throws Exception{
        List<StudentDTO> list = mapperUtil.mapList(service.getStudentsOrderedByAge(), StudentDTO.class);
        return ResponseEntity.ok(new GenericResponse<>(200, "success", list));
    }
}
