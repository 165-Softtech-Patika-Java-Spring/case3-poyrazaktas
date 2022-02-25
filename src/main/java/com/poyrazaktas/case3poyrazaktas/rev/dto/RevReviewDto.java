package com.poyrazaktas.case3poyrazaktas.rev.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RevReviewDto {
    private Long productId;

    private Long userId;

    private String content;
}
