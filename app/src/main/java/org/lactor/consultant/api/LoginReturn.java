package org.lactor.consultant.api;

/**
 * Created by nbeesett on 10/1/17.
 */
public class LoginReturn {

    private boolean success;
    private String authToken;
    private String timeoutStamp;
    private String errorMessage;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getTimeoutStamp() {
        return timeoutStamp;
    }

    public void setTimeoutStamp(String timeoutStamp) {
        this.timeoutStamp = timeoutStamp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public LoginReturn(boolean success, String authToken, String timeoutStamp, String errorMessage) {

        this.success = success;
        this.authToken = authToken;
        this.timeoutStamp = timeoutStamp;
        this.errorMessage = errorMessage;
    }
}
