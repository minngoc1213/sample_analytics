package com.example.sample_analytics.web.error;

import com.example.sample_analytics.common.exception.ResourceNotFoundException;
import com.example.sample_analytics.web.response.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionTranslator {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse<?>> handleResourceNotFoundException(ResourceNotFoundException exception) {
        String message;
        if (exception.getMessage() != null) {
            message = exception.getMessage();
        } else {
            message = "";
        }
        return ResponseEntity.status(HttpStatus.OK).body(APIResponse.newFailureResponse(message));
    }

}
