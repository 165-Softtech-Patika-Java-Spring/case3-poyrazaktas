package com.poyrazaktas.case3poyrazaktas.rev.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="REV_REVIEW")
@Getter
@Setter
public class RevReview {
    @Id
    @GeneratedValue(generator = "RevReview")
    @SequenceGenerator(name="RevReview", sequenceName = "SEQ_REV_REVIEW")
    private Long id;

    @Column(name="ID_PRD_PRODUCT")
    private Long productId;

    @Column(name="ID_USR_USER")
    private Long userId;

    @Column(name="CONTENT")
    private String content;
}
