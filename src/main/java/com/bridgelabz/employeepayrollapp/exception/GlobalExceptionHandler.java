package com.bridgelabz.employeepayrollapp.exception;

import com.bridgelabz.employeepayrollapp.dto.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<ResponseDTO> handleCustomException(CustomException customException){
        return new ResponseEntity<>(new ResponseDTO(customException.getMessage(), null), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<ResponseDTO> handleValidationException(ValidationException validationException){
        return new ResponseEntity<>(new ResponseDTO(validationException.getMessage(), null), HttpStatus.NOT_FOUND);
    }
}