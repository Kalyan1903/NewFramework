package com.ui.pojo;

public class User
{
    private String email;
    private String password;
    public User(String email, String password)
    {
        super();
        this.email = email;
        this.password = password;
    }


    public String getEmail() {

        return email;
    }

    public String getPassword() {

        return password;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    @Override
    public String toString() {

        return "email"+email+"password"+password ;
    }
}
