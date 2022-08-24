package com.example.backendproject.advise;
import com.example.backendproject.dto.Api;
import com.example.backendproject.exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAdvise {
    @ExceptionHandler(value = ApiException.class)
        public ResponseEntity apiException(ApiException apiException){
            return ResponseEntity.status(400).body(new Api(apiException.getMessage(), 400));
        }
    }
