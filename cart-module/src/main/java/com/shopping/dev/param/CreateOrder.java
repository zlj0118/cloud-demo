package com.shopping.dev.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 创建 JYQ  on  2018/11/20,20:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrder {
    private String userId;
    private String orderId;
    private Integer paymentType;
    private Date createTime;
    private String receiverName;
    private String receiverMobile;
    private String receiverAddress;
    private  List<OrderItemParam> orderItemParamList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public List<OrderItemParam> getOrderItemParamList() {
        return orderItemParamList;
    }

    public void setOrderItemParamList(List<OrderItemParam> orderItemParamList) {
        this.orderItemParamList = orderItemParamList;
    }
}





