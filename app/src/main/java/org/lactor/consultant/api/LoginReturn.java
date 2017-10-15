package org.lactor.consultant.api;

public class LoginReturn {

    private boolean success;
    private String authToken;
    private String timeoutStamp;
    private String errorMessage;

    public boolean isSuccess() {
        return success;
    }

    public String getAuthToken() {
        return authToken;
    }

    public String getTimeoutStamp() {
        return timeoutStamp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
