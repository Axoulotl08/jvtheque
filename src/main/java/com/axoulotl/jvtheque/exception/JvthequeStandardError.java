package com.axoulotl.jvtheque.exception;

import lombok.Getter;

@Getter
public class JvthequeStandardError extends Exception{
    private StandardErrorEnum errorType;
    private String comment;

    public JvthequeStandardError(StandardErrorEnum errorType, String comment){
        super();
        this.errorType = errorType;
        this.comment = comment;
    }

    public JvthequeStandardError() {
    }
}
