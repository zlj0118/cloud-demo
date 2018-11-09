package com.shopping.dev.service;

import com.shopping.dev.entity.User;
import com.shopping.dev.repository.LoginRepository;
import com.shopping.dev.utils.ResultWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author:毕胜朋
 * @date:2018/11/7 19:13
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private LoginRepository repository;


    @Override
    public ResultWrapper findByUsername(String username, String password) {
        User user = repository.findByUsername(username);
        System.out.println(user);
        if (user.getUsername().equals(username)&&user.getPassword().equals(password)){
            return ResultWrapper.success(user);
        }
        return ResultWrapper.error(403,"账号或密码错误") ;
    }
}
