package com.birthdaymanager.exceptions;

/**
 * Created by umesh.soni on 3/17/2017.
 */
public class SqlSessionFactoryCreatorException extends RuntimeException {

    private static final long serialVersionUID = -3338166707608147652L;
    private int errorCode;

    public SqlSessionFactoryCreatorException() {

    }

    public SqlSessionFactoryCreatorException(final Throwable cause) {
        super(cause);
    }

    public SqlSessionFactoryCreatorException(final String message) {
        super(message);
    }

    public SqlSessionFactoryCreatorException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public SqlSessionFactoryCreatorException(final int errorCode,final String message) {
        super(message);
        this.setErrorCode(errorCode);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
