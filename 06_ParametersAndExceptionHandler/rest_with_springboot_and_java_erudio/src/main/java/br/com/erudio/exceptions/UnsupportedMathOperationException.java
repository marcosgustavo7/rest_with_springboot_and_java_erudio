package br.com.erudio.exceptions;


import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)


public class UnsupportedMathOperationException extends RuntimeException {

	public UnsupportedMathOperationException(String ex) {
		super(ex);
	}

	private static final long serialVersionUID = 1L;
	
}
