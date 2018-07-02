package jsonModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Employee {

    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("emailaddress")
    @Expose
    private String emailaddress;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("acceptedTerms")
    @Expose
    private String acceptedTerms;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return emailaddress;
    }

    public void setEmail(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAcceptedTerms() {
        return acceptedTerms;
    }

    public void setAcceptedTerms(String acceptedTerms) {
        this.acceptedTerms = acceptedTerms;
    }

}
