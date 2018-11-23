package com.shopping.dev.entity;


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




}
