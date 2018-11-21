package com.shopping.dev.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Pattern(regexp = "^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$",message ="用户名必须" )
    private String username;
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$",message = "密码（6-16位数字和字母的组合)")
    private String password;
    @Pattern(regexp = ("^[1][3,4,5,8][0-9]{9}$"),message = "手机号非法")
    private String phone;
    @Pattern(regexp = "([0-9a-z]+\\\\.)+[0-9a-z]+$",message = "不是正确邮箱格式")
    private String email;
    private java.sql.Timestamp created;
    private java.sql.Timestamp updated;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public java.sql.Timestamp getCreated() {
        return created;
    }

    public void setCreated(java.sql.Timestamp created) {
        this.created = created;
    }


    public java.sql.Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(java.sql.Timestamp updated) {
        this.updated = updated;
    }

    public User() {
    }

    public User(String username, String password, String phone, String email, Timestamp created, Timestamp updated) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.created = created;
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
