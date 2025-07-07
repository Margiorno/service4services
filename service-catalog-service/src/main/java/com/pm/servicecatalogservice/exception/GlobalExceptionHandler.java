package com.pm.servicecatalogservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidCategoryException.class)
    public ResponseEntity<Map<String,String>> handleInvalidCategoryException(InvalidCategoryException ex) {
        Map<String,String> map = new HashMap<>();

        map.put("message", ex.getMessage());
        return ResponseEntity.badRequest().body(map);
    }

    @ExceptionHandler(InvalidTemplateNameException.class)
    public ResponseEntity<Map<String,String>> handleInvalidTemplateNameException(InvalidTemplateNameException ex) {
        Map<String,String> map = new HashMap<>();

        map.put("message", ex.getMessage());
        return ResponseEntity.badRequest().body(map);
    }


}
