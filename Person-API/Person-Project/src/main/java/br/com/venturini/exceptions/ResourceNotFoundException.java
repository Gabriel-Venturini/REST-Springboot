package br.com.venturini.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedMathOperationException extends RuntimeException{

	// construtor
	public UnsuportedMathOperationException(String ex) {
		super(ex);
	}

	private static final long serialVersionUID = 1L;
}
