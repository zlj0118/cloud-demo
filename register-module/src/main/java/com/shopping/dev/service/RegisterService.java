package com.shopping.dev.service;

import com.shopping.dev.entity.User;
import com.shopping.dev.utils.ResultWrapper;
import org.springframework.stereotype.Service;

/**
 * @author:毕胜朋
 * @date:2018/11/8 8:46
 */
@Service
public interface RegisterService {
    /**
     * 根据用户名查询数据库
     * @param username
     * @return
     */
    ResultWrapper findUserByUsername(String username);

    /**
     * 像数据库插入数据
     * @param user
     * @return
     */
    User addAll(User user);
}
