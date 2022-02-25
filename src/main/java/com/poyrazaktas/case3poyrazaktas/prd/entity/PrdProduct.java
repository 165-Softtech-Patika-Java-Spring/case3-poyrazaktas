package com.poyrazaktas.case3poyrazaktas.prd.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="PRD_PRODUCT")
@Getter
@Setter
public class PrdProduct {
    @Id
    @GeneratedValue(generator = "PrdProduct")
    @SequenceGenerator(name="PrdProduct", sequenceName = "SEQ_PRD_PRODUCT")
    private Long id;

    @Column(name = "NAME",nullable = false)
    private String name;

    @Column(name="PRICE",precision = 19, scale = 2)
    private BigDecimal price;
}
