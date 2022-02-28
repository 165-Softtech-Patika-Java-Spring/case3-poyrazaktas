package com.poyrazaktas.case3poyrazaktas.rev.enums;

import com.poyrazaktas.case3poyrazaktas.gen.exception.BaseErrorMessage;

public enum RevReviewErrorMessage implements BaseErrorMessage {
    ITEM_NOT_FOUND("Review not found!");

    private String message;

    RevReviewErrorMessage(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
