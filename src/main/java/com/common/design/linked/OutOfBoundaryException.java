package com.common.design.linked;

/**
 * 定义一个异常,在现行表查找时，可能会产生异常
 * Created by Jerry on 2014/11/23.
 */
public class OutOfBoundaryException extends Exception{

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public OutOfBoundaryException() {
        super();
    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public OutOfBoundaryException(String message) {
        super(message);
    }
}
