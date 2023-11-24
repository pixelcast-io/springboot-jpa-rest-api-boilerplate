package com.example.api.exception;

import java.io.Serializable;

public class ApiErrorResponse implements Serializable {
    private String errorCode;
    private String message;
    private String additionalInfo;
    private long timestamp;

    public ApiErrorResponse(String errorCode, String message, String additionalInfop) {
        this.errorCode = errorCode;
        this.message = message;
        this.additionalInfo = additionalInfo;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
