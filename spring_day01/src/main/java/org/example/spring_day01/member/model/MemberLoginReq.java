package org.example.spring_day01.member.model;

public class MemberLoginReq {
    private String email;
    private String password;

    public MemberLoginReq() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
