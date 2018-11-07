package com.shopping.dev.entity;


import javax.persistence.*;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String phone;
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

}
