package com.medsync.pm.exception;

public class PatientDoesNotExist extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PatientDoesNotExist(String message) {
		super(message);
	}

}
