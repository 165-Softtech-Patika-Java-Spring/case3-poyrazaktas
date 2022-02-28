package com.poyrazaktas.case3poyrazaktas.usr.enums;

import com.poyrazaktas.case3poyrazaktas.gen.exception.BaseErrorMessage;

public enum UsrUserErrorMessage implements BaseErrorMessage {
    ITEM_NOT_FOUND("User not found!"),
    ;

    private String message;
    UsrUserErrorMessage(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
