package com.ordermgmt.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderExceptionController {

	@ExceptionHandler(value=OrdernotFoundException.class)
	public ResponseEntity<Object> exception(OrdernotFoundException ex)
	{
		return new ResponseEntity<>("Unable to find the order ", HttpStatus.NOT_FOUND);
	}
}
