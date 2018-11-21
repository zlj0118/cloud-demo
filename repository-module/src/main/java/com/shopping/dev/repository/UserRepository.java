package com.shopping.dev.repository;


import com.shopping.dev.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
//    根据号码查询user对象: 校验
    User findUserByPhone(String phone);
//    根据用户名查询user对象: 校验
    User findUserByUsername(String username);
}
