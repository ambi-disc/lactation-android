package org.lactor.consultant.modules.authorization.webrequests;

public class LoginResult {
    public boolean success;
    public String authToken;
    public String timeoutStamp;
    public String errorMessage;

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
