package com.tsanda.employeeApp.exception;

import org.apache.log4j.Logger;

public class NullKeyException extends DatabaseException {

    private static final Logger log = Logger.getLogger(NullKeyException.class);
    private String details;

    public NullKeyException() {
        this.details = "Key is null!";
    }

    public NullKeyException(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "NullKeyException{" +
                "details='" + details + '\'' +
                '}';
    }
}
