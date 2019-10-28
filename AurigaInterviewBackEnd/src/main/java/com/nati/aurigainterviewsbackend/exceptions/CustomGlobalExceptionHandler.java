package com.nati.aurigainterviewsbackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	// here we handle all the 'ApplicationException' we throw.
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<CustomErrorResponse> customHandleNotFound(ApplicationException ex, WebRequest request) {
    	System.out.println("get into @ExceptionHandler@ExceptionHandler");
        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        // just if it's ApplicationException with ErrorType.
        if(ex.getErrorType() != null) {
        	errors.setErrorMessage(ex.getErrorType().toString());
            errors.setStatus(ex.getErrorType().getErrorNumber());
        }
        // we print to the log the StackTrace
        ex.printStackTrace();
        // we return to the client object CustomErrorResponse with all the details of the error,
        // and general bad 'HttpStatus' just to tell the client right away that it's bad response.
        return new ResponseEntity<CustomErrorResponse>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
