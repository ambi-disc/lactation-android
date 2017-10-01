package org.lactor.consultant.api;

/**
 * Created by nbeesett on 10/1/17.
 */
public class AccountRequest {

    public String firstName;
    public String lastName;
    public String emailAddress;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountRequest(String firstName, String lastName, String emailAddress, String profession, String password) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.profession = profession;
        this.password = password;
    }

    public String profession;
    public String password;
}
