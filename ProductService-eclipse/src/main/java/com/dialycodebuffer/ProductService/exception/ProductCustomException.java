package com.dialycodebuffer.ProductService.exception;

public class ProductCustomException extends RuntimeException {

	private String errorCode;

	public ProductCustomException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	

}
