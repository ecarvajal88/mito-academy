package com.mitocode.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollDetailDTO {

    public Integer idEnrollDetail;

    @JsonBackReference
    private EnrollDTO enroll;

    @NotNull
    @JsonIncludeProperties(value = {"idCourse"})
    private CourseDTO course;

    @NotNull
    public String classroom;
}
