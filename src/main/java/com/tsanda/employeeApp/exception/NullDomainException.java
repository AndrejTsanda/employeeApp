package com.tsanda.employeeApp.exception;

import org.apache.log4j.Logger;

public class NullDomainException extends DatabaseException {

    private static final Logger log = Logger.getLogger(NullDomainException.class);
    private String details;

    public NullDomainException() {
        this.details = "Domain is null!";
    }

    public NullDomainException(String details) {
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
        return "NullDomainException{" +
                "details='" + details + '\'' +
                '}';
    }
}
