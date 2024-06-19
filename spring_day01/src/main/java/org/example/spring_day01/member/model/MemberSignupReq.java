package org.example.spring_day01.member.model;


public class MemberSignupReq {
    private String email;
    private String password;
    private String name;

    public MemberSignupReq() {
    }

    @Override
    public String toString() {
        return "MemberSignupReq{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
