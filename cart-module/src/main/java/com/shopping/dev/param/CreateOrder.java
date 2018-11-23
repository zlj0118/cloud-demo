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


}





