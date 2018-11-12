package com.shopping.dev.service;

import com.shopping.dev.utils.ResultWrapper;

/**
 * @author:毕胜朋
 * @date:2018/11/7 19:13
 */
public interface LoginService {
    ResultWrapper findByUsername(String username, String password);
}
