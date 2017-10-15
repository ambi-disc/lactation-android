package org.lactor.consultant.api;

public class AccountRequest {

    public String firstName;
    public String lastName;
    public String emailAddress;
    public String profession;
    public String password;

    public AccountRequest(String firstName, String lastName, String emailAddress, String profession, String password) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.profession = profession;
        this.password = password;
    }   
}
