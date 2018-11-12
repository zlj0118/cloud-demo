package com.shopping.dev.service;

import com.shopping.dev.entity.User;
import com.shopping.dev.repository.RegisterRepository;
import com.shopping.dev.utils.ResultWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author:毕胜朋
 * @date:2018/11/8 8:47
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Resource
    private RegisterRepository repository;

    /**
     * 查询数据库是否有重复用户名
     *
     * @param username
     * @return
     */
    @Override
    public ResultWrapper findUserByUsername(String username) {
        User user = repository.findUserByUsername(username);
        if (user.getUsername().equals(username)) {
            return ResultWrapper.error(401, "用户名已存在");
        }
        return ResultWrapper.success(user);
    }

    @Transactional
    public User addAll(User user) {
        return repository.save(user);
    }
}
