package com.flightplanning.flight.exception;

import com.flightplanning.flight.constant.ErrorConstants;

public class NoDataFoundException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3428938007647691358L;

	public NoDataFoundException(ErrorConstants error) {
		super(error);
	}

}
