package com.javajober.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.javajober.core.util.response.ApiResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartException;

@RestControllerAdvice
@Slf4j
public class ApplicationExceptionHandler {

    public ApplicationExceptionHandler() {

    }

    @ExceptionHandler(ApplicationException.class)
    protected ResponseEntity<ApiResponse.InvalidResponse> handleApplicationException (ApplicationException e) {
        log.error(e.getStatus().getMessage() + " : {}", e.getInfo());
        return ApiResponse.invalidResponse(e.getStatus(), e.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ApiResponse.InvalidResponse> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.error(e.getMessage());
        return ApiResponse.invalidResponse(ApiStatus.OBJECT_EMPTY, e.getMessage());
    }

    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity<ApiResponse.InvalidResponse> handleServletRequestBindingException (MissingPathVariableException e) {
        log.error(e.getMessage());
        return ApiResponse.invalidResponse(ApiStatus.OBJECT_EMPTY, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiResponse.InvalidResponse> handleMethodArgumentTypeMismatchException (MethodArgumentTypeMismatchException e) {
        log.error(e.getMessage());
        return ApiResponse.invalidResponse(ApiStatus.OBJECT_EMPTY, e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse.InvalidResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ApiResponse.invalidResponse(ApiStatus.INVALID_DATA, e.getMessage());
    }

    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<ApiResponse.InvalidResponse> handleMultipartException(MultipartException e) {
        log.error(e.getMessage());
        return ApiResponse.invalidResponse(ApiStatus.PAYLOAD_TOO_LARGE, e.getMessage());
    }
}