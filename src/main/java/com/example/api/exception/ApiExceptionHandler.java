package com.example.api.exception;

import com.example.api.constant.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiException.class})
    public ResponseEntity<ApiErrorResponse> handleApiException(ApiException e){

        HttpStatus status;
        ApiErrorResponse errorResponse = new ApiErrorResponse(e.getErrorCode(), e.getMessage(), e.getAdditionalInfo());

        if (e.getErrorCode().startsWith(ErrorCode.NOT_FOUND_ERROR_CODE_RANGE)){
            status = HttpStatus.NOT_FOUND;
        }
        else if(e.getErrorCode().startsWith(ErrorCode.VALIDATION_ERROR_CODE_RANGE)) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }else {
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(errorResponse, status);
    }
}
