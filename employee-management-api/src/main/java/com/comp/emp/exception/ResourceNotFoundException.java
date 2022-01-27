/*
 * 
 */
package com.comp.emp.exception;

/**
 * The Class ResourceNotFoundException.
 */
public class ResourceNotFoundException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new resource not found exception.
	 *
	 * @param msg the msg
	 */
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
