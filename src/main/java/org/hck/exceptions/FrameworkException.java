package org.hck.exceptions;

/**
 * FrameworkException extends RuntimeException which is the superclass of those exceptions that can be thrown during
 * the normal operation of the Java Virtual Machine.
 * FrameworkException and its subclasses are unchecked exceptions.
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/lang/RuntimeException.html">Oracle.doc:RuntimeException</a>
 * @author Harshavardhan Kavuri
 * @version 1.0
 */
public class FrameworkException extends RuntimeException {

    /**
     * Constructs a new FrameworkException exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a call to initCause.
     * @param message The detail message. The detail message is saved for later retrieval by the getMessage() method.
     */
    public FrameworkException(String message){
        super(message);
    }

    /**
     * Constructs a new FrameworkException  with the specified detail message and cause.
     *
     * Note that the detail message associated with cause is not automatically incorporated in
     * this runtime exception's detail message.
     * @param message the detail message (which is saved for later retrieval by the getMessage() method).
     * @param cause the cause (which is saved for later retrieval by the getCause() method).
     *               (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public FrameworkException(String message, Throwable cause){
        super(message, cause);
    }
}