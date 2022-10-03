package com.leng.analizador.analyzer.models.error;

public class Error {
    private final ErrorType errorType;
    private final String expected;
    private final String description;


    public Error(ErrorType errorType, String expected, String description) {
        this.errorType = errorType;
        this.expected = expected;
        this.description = description;
    }


    public ErrorType getErrorType() {
        return this.errorType;
    }


    public String getExpected() {
        return this.expected;
    }


    public String getDescription() {
        return this.description;
    }


    @Override
    public String toString() {
        return "{" +
            " errorType='" + getErrorType() + "'" +
            ", expected='" + getExpected() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }



}
