package com.softsignatureslab.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomError {
    private int status;
    private String error;
}
