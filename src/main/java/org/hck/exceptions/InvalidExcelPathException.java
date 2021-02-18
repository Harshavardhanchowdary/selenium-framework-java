package org.hck.exceptions;

public class InvalidExcelPathException extends FrameworkException{
    public InvalidExcelPathException(String message) {
        super(message);
    }

    public InvalidExcelPathException(String message, Throwable cause) {
        super(message, cause);
    }
}
