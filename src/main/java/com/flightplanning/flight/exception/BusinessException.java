package com.flightplanning.flight.exception;

import com.flightplanning.flight.constant.ErrorConstants;

public class BusinessException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5966584640501810871L;
	
	private final ErrorConstants error;

	public BusinessException(ErrorConstants error) {
		super();
		this.error = error;
	}

	public ErrorConstants getError() {
		return error;
	}

}
