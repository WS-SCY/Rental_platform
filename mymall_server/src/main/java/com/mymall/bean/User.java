package com.mymall.bean;


public class User {
    private int id;
    private String name;
    private String login_password;
    private int age;
    private String sex;
    private String login_tel;
    private String wechat;
    private String address;
    private String permission;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login_password='" + login_password + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", login_tel='" + login_tel + '\'' +
                ", wechat='" + wechat + '\'' +
                ", address='" + address + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin_password() {
        return login_password;
    }

    public void setLogin_password(String login_password) {
        this.login_password = login_password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLogin_tel() {
        return login_tel;
    }

    public void setLogin_tel(String login_tel) {
        this.login_tel = login_tel;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public User() {
    }

    public User(String name, String login_password, int age, String sex, String login_tel, String wechat, String address, String permission) {
        this.name = name;
        this.login_password = login_password;
        this.age = age;
        this.sex = sex;
        this.login_tel = login_tel;
        this.wechat = wechat;
        this.address = address;
        this.permission = permission;
    }
}
