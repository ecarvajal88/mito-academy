package com.mitocode.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDTO {

    private Integer idStudent;
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Size(min = 10, max = 10)
    private String cardId;

    @NotNull
    private Integer age;
}
