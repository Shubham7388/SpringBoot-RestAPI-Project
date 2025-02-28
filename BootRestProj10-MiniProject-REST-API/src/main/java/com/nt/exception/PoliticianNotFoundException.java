package com.nt.exception;

public class PoliticianNotFoundException extends RuntimeException{
	public PoliticianNotFoundException(String msg) {
		super(msg);
	}
}
