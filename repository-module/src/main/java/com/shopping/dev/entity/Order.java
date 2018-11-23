package com.shopping.dev.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_order")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Order {
  @Id
  private String orderId;
  private String payment;
  private Long paymentType;
  private String postFee;
  private Long status;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private java.sql.Timestamp paymentTime;
  private java.sql.Timestamp consignTime;
  private java.sql.Timestamp endTime;
  private java.sql.Timestamp closeTime;
  private String shippingName;
  private String shippingCode;
  private Long userId;
  private String buyerMessage;
  private String buyerNick;
  private Long buyerRate;

    public void setPostFee(String postFee) {
        this.postFee = postFee;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }


    public java.sql.Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.sql.Timestamp createTime) {
        this.createTime = createTime;
    }


    public java.sql.Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(java.sql.Timestamp updateTime) {
        this.updateTime = updateTime;
    }


    public java.sql.Timestamp getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(java.sql.Timestamp paymentTime) {
        this.paymentTime = paymentTime;
    }


    public java.sql.Timestamp getConsignTime() {
        return consignTime;
    }

    public void setConsignTime(java.sql.Timestamp consignTime) {
        this.consignTime = consignTime;
    }


    public java.sql.Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(java.sql.Timestamp endTime) {
        this.endTime = endTime;
    }


    public java.sql.Timestamp getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(java.sql.Timestamp closeTime) {
        this.closeTime = closeTime;
    }


    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }


    public String getShippingCode() {
        return shippingCode;
    }

    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage;
    }


    public String getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick;
    }


    public Long getBuyerRate() {
        return buyerRate;
    }

    public void setBuyerRate(Long buyerRate) {
        this.buyerRate = buyerRate;
    }

}
