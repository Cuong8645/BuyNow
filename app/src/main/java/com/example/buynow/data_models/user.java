package com.example.buynow.data_models;

public class user {
      private String user_name;
      private String user_password;
      private String user_phone;
      private String user_address;
      private String user_birth;
      private String user_sex;

    public user(String user_name, String user_password, String user_phone, String user_address, String user_birth, String user_sex) {
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_phone = user_phone;
        this.user_address = user_address;
        this.user_birth = user_birth;
        this.user_sex = user_sex;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_birth() {
        return user_birth;
    }

    public void setUser_birth(String user_birth) {
        this.user_birth = user_birth;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }
}
