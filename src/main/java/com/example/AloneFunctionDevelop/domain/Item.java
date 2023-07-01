package com.example.AloneFunctionDevelop.domain;

import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Item{

    @NotNull
    private int num;
    @NotBlank
    private String name;

    public Item(int num, String name) {
        this.num = num;
        this.name = name;
    }
}
