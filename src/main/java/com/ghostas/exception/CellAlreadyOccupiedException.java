package com.ghostas.exception;

public class CellAlreadyOccupiedException extends Exception {

    public CellAlreadyOccupiedException() {
        super();
    }
    public CellAlreadyOccupiedException(String message) {
        super(message);
    }
}
