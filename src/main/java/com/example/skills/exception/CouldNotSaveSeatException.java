package com.example.skills.exception;

public class CouldNotSaveSeatException extends RuntimeException {

	public CouldNotSaveSeatException() {
		super("Seat with entered ID do not exist!");
	}

}
