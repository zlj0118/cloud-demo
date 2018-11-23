package com.shopping.dev.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建 JYQ  on  2018/11/21,17:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemParam {
    private Integer itemId;
    private  String itemNum;
    private  String title;
    private  String image;
    private  String price;
}
