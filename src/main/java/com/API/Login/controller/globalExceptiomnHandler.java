package com.API.Login.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.API.Login.Entity.ApiResponse;

@RestController
@RestControllerAdvice
public class globalExceptiomnHandler{
     
//private static final long serialVersionUID = -1903376422176409372L;

//	private static final long serialVersionUID = 1L;

	@ExceptionHandler(value = OurCustomizedException.class)
	String exceptionhandler(OurCustomizedException ex){
		String message = ex.getMessage();
		ApiResponse apiResponse=new ApiResponse();
		apiResponse.setError(404);
		apiResponse.setMessage("Not Found!!!");
		
		return message;
	}
	
}
