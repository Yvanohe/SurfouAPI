package fr.lubac.surfouAPI.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> handleIllegalArgumentException (IllegalArgumentException ex) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);	
	}
	
	@ExceptionHandler(EntityExistsException.class)
	public ResponseEntity<ErrorResponse> handleEntityExistsException (EntityExistsException ex) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);	
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);	
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidEception(MethodArgumentNotValidException ex) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), processErrorMessageFromValidationException(ex));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);		
	}
	
	
	/**
	 * Process MethodArgumentValidaException to customize error Message
	 * @param MethodArgumentNotValidException ex
	 * @return : string of each field name and default message
	 */
	private String processErrorMessageFromValidationException (MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors =  result.getFieldErrors();
        
        StringBuilder errorMessage = new StringBuilder();
        for (FieldError fe : fieldErrors) {
            errorMessage.append("[")
            .append(fe.getField())
            .append("] : ")
            .append(fe.getDefaultMessage())
            .append(". ");
        }
        
        return errorMessage.toString();
        
        
	}
}
