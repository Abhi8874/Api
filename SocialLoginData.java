package com.aws.apiproject;

public class SocialLoginData {
    String email;
    String aouth;

    public SocialLoginData(String email, String aouth) {
        this.email = email;
        this.aouth = aouth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAouth() {
        return aouth;
    }

    public void setAouth(String aouth) {
        this.aouth = aouth;
    }
}
