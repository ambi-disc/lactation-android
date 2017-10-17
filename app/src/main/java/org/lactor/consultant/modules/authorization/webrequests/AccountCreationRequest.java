package org.lactor.consultant.modules.authorization.webrequests;

public class AccountCreationRequest {

    public String firstName;
    public String lastName;
    public String emailAddress;
    public String profession;
    public String password;

    public AccountCreationRequest(String firstName, String lastName, String emailAddress, String profession, String password) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.profession = profession;
        this.password = password;
    }   
}
