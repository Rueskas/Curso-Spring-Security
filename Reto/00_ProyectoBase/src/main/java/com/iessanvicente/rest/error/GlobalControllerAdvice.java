package com.iessanvicente.rest.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {
	

	@ExceptionHandler(NewUserWithDifferentPasswordsException.class)
	public ApiError handleNewUserErrors(Exception ex) {
		return ApiError.builder()
				.estado(HttpStatus.BAD_REQUEST)
				.fecha(LocalDateTime.now())
				.mensaje(ex.getMessage())
				.build();
	}
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ApiError  apiError = ApiError.builder()
								.estado(status)
								.fecha(LocalDateTime.now())
								.mensaje(ex.getMessage())
								.build();
		return ResponseEntity.status(status).headers(headers).body(apiError);
	}
	
	
	private ResponseEntity<ApiError> buildErrorResponseEntity(HttpStatus status, String message) {
		return ResponseEntity.status(status)
					.body(ApiError.builder()
							.estado(status)
							.mensaje(message)
							.build());
	}
	
	

}
