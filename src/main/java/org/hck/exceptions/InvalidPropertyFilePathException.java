package org.hck.exceptions;

public class InvalidPropertyFilePathException extends FrameworkException{

    public InvalidPropertyFilePathException(String message) {
        super(message);
    }

    public InvalidPropertyFilePathException(String message, Throwable cause) {
        super(message, cause);
    }
}
