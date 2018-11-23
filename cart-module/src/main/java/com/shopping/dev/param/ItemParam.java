package com.shopping.dev.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建 JYQ  on  2018/11/8,16:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemParam {
    private  Long userId;
    private  Long itemId;
    private   Integer itemNum;
}
