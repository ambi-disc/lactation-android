package org.lactor.consultant.authentication.webrequests;

public class LoginResult {
    public boolean success;
    public String authToken;
    public String timeoutTimestamp;
    public String errorMessage;

    public boolean isSuccess() {
        return success;
    }

    public String getAuthToken() {
        return authToken;
    }

    public String getTimeoutStamp() {
        return timeoutTimestamp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
