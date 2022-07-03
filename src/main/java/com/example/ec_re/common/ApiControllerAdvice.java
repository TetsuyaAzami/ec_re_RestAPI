package com.example.ec_re.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import com.example.ec_re.exception.SessionIdNotFoundException;

@RestControllerAdvice
public class ApiControllerAdvice {
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(SessionIdNotFoundException.class)
	public ResponseError handleSessionIdNotFound(SessionIdNotFoundException ex,
			WebRequest request) {
		ResponseError re = new ResponseError(HttpStatus.UNAUTHORIZED.value(), ex.getMessage());
		return re;
	}
}
