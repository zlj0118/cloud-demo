package com.shopping.dev.service;

import com.shopping.dev.entity.User;
import com.shopping.dev.utils.ResultWrapper;

/**
 * @author:毕胜朋
 * @date:2018/11/12 11:30
 */
public interface UserService {
    User findByUsername(User User);

    /**
     * 根据user对象的phone 查询user对象
     * @param user
     * @return
     */
    User findUserByPhone(User user);

    /**
     * 像数据库插入数据
     * @param user
     * @return
     */
    User addAll(User user);

    /**
     * 退出登录
     * @return
     */
  ResultWrapper exit();

}
