package com.epam.automation.exception.exeptionsForTask;

public class NoSubjectExceprion extends Exception {
    public NoSubjectExceprion() {
    }

    public NoSubjectExceprion(String message) {
        super(message);
    }

    public NoSubjectExceprion(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSubjectExceprion(Throwable cause) {
        super(cause);
    }
}
