package com.poyrazaktas.case3poyrazaktas.prd.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PrdProductSaveReqDto {
    private String name;
    private BigDecimal price;
}
