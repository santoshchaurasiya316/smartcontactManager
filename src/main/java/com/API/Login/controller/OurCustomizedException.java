package com.API.Login.controller;

public class OurCustomizedException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public OurCustomizedException(String msg){
		super(msg);
	}
}
