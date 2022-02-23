package com.poyrazaktas.case3poyrazaktas.gen.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class CustomExceptionResponse {
    private Date date;
    private String message;
    private String description;
}
