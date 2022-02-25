package com.poyrazaktas.case3poyrazaktas.rev.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RevReviewUpdateReqDto {
    private Long id;

    private Long productId;

    private Long userId;

    private String content;
}
