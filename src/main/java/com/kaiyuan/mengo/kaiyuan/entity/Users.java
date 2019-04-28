package com.kaiyuan.mengo.kaiyuan.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_table")
public class Users {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "username", length = 25)
    private String userName;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name="password_salt",length = 50)
    private String password_salt;

    private int uid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_salt() {
        return password_salt;
    }

    public void setPassword_salt(String password_salt) {
        this.password_salt = password_salt;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
