package com.shopping.dev.entity;

import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "tb_message")
public class UserMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    private Long uid;
    private String nickName;
    private String gender;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private java.sql.Date birthday;
    private String hobbies;
    private String email;
    private String realName;
    private String address;
    private String imagePath;
    private String marriage;
    private String income;
    private String idCard;
    private String teach;
    private String industry;

    @Override
    public String toString() {
        return "UserMessage{" +
                "messageId=" + messageId +
                ", uid=" + uid +
                ", nickName='" + nickName + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", hobbies='" + hobbies + '\'' +
                ", email='" + email + '\'' +
                ", realName='" + realName + '\'' +
                ", address='" + address + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", marriage='" + marriage + '\'' +
                ", income='" + income + '\'' +
                ", idCard='" + idCard + '\'' +
                ", teach='" + teach + '\'' +
                ", industry='" + industry + '\'' +
                '}';
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTeach() {
        return teach;
    }

    public void setTeach(String teach) {
        this.teach = teach;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }


}
