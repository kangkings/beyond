package org.example.spring_day01.member.model;

public class MemberSignupRes {
    private String email;
    private String name;

    public MemberSignupRes() {
    }

    @Override
    public String toString() {
        return "MemberSignupRes{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
