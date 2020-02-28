package com.capgemini.desafio.exception;

public class BancoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5046847836646952028L;

	public BancoException(String exception) {
        super(exception);
    }
}
