package com.tsanda.employeeApp.exception;

import org.apache.log4j.Logger;

public class ErrorQueryException extends DatabaseException {

    private static final Logger log = Logger.getLogger(ErrorQueryException.class);
    private String details;

    public ErrorQueryException() {
        this.details = "Undefined SQL query error!";
    }

    public ErrorQueryException(String details) {
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
        return "ErrorQueryException{" +
                "details='" + details + '\'' +
                '}';
    }
}
