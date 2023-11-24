package com.example.api.exception;

public class ApiException extends Exception{

    private final String errorCode;
    private final String additionalInfo;

    public ApiException( String errorCode, String message, String additionalInfo) {
        super(message);
        this.errorCode = errorCode;
        this.additionalInfo = additionalInfo;
    }

    public ApiException(String errorCode, String message,  String additionalInfo, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        this.additionalInfo = additionalInfo;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }
}
