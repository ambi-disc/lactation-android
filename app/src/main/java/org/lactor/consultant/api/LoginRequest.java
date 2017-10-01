package org.lactor.consultant.api;

/**
 * Created by nbeesett on 10/1/17.
 */
public class LoginRequest {

    public String email;
    public String password;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
