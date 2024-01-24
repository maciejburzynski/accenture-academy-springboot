package com.accenture.academy.priest;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriestDto {
    private String name;
    @NotNull(message = "Height must not be null")
    private  Integer height;
    @NotNull(message = "Age must not be blank")
    private Integer age;
}
