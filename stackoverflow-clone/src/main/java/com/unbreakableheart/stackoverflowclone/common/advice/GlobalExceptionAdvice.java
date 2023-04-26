package com.unbreakableheart.stackoverflowclone.common.advice;

import com.unbreakableheart.stackoverflowclone.common.exception.CustomException;
import com.unbreakableheart.stackoverflowclone.common.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionAdvice {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException exception) {
        ErrorResponse errorResponse = ErrorResponse.of(exception.getExceptionCode());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exception.getExceptionCode().getCode()));
    }

    @ExceptionHandler
    public ErrorResponse handleException(Exception e){
        log.info("error 500 {}", e.toString());
        return ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR, e.toString());
    }
}
