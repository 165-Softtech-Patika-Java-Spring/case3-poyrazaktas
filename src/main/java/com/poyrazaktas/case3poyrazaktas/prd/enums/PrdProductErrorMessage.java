package com.poyrazaktas.case3poyrazaktas.prd.enums;

import com.poyrazaktas.case3poyrazaktas.gen.exception.BaseErrorMessage;

public enum PrdProductErrorMessage implements BaseErrorMessage {
    ITEM_NOT_FOUND("Product Not Found!"),;

    private String message;
    PrdProductErrorMessage(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
