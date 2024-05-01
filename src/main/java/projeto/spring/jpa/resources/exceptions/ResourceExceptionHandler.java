package projeto.spring.jpa.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import projeto.spring.jpa.services.exceptions.DatabaseException;
import projeto.spring.jpa.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		
		String error = "Not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError objError = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(objError);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> databaseException(DatabaseException e, HttpServletRequest request){
		
		String error = "Database error";
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		StandardError objError = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI()); 
		
		return ResponseEntity.status(status).body(objError);
	}

}
