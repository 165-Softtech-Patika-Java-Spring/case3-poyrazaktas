package com.poyrazaktas.case3poyrazaktas.gen.exception;

import com.poyrazaktas.case3poyrazaktas.gen.dto.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleUnhandledExceptions(Exception ex, WebRequest webRequest){
        CustomExceptionResponse customExceptionResponse = getCustomExceptionResponse(ex.getMessage(), webRequest);
        RestResponse restResponse = RestResponse.error(customExceptionResponse);
        return new ResponseEntity<>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleItemNotFoundException(ItemNotFoundException ex, WebRequest webRequest){
        CustomExceptionResponse customExceptionResponse = getCustomExceptionResponse(ex.getErrorMessage().getMessage(), webRequest);
        RestResponse restResponse = RestResponse.error(customExceptionResponse);
        return new ResponseEntity<>(restResponse,HttpStatus.NOT_FOUND);
    }

    private CustomExceptionResponse getCustomExceptionResponse(String errorMessage, WebRequest webRequest) {
        Date date = new Date();
        String message = errorMessage;
        String description = webRequest.getDescription(false);

        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse(date, message, description);
        return customExceptionResponse;
    }
}
