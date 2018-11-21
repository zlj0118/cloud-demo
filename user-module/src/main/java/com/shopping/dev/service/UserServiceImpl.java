package com.shopping.dev.service;

import com.shopping.dev.entity.User;
import com.shopping.dev.repository.UserRepository;
import com.shopping.dev.utils.JwtUtils;
import com.shopping.dev.utils.ResultWrapper;
import org.apache.shiro.SecurityUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author:毕胜朋
 * @date:2018/11/12 11:30
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository repository;
    @Resource
    private RedisTemplate redisTemplate;


    /**
     * 登录 根据用户名查询数据库是否有该用户,判断
     * @param user
     * @return
     */
    @Override
    public User findByUsername(User user) {

        System.out.println(user.getUsername());
        User user1 = repository.findByUsername(user.getUsername());
        System.out.println(user1);
        if (user1 != null && !user1.equals("") && user1.getUsername().equals(user.getUsername()) && user1.getPassword().equals(user.getPassword())) {
            return user1;
        }
        return null;
    }

    /**
     * 用户名不能重复, 电话号码不能重复
     * @param user
     * @return
     */
    @Override
    public User findUserByPhone( User user) {
        // 根据前端传入表单数据判断是否存在同名
        User user1 = repository.findUserByPhone(user.getPhone());
        if (user1 != null) {
            return user1;
        } else {
            user1 = repository.findUserByUsername(user.getUsername());
            if (user1 != null) {
                return user1;
            } else {
                return null;
            }
        }

    }

    /**
     * 注册成功把数据插入数据库
     *
     * @param user
     * @return
     */
    @Transactional
    @Override
    public User addAll(User user) {
        Timestamp d = new Timestamp(System.currentTimeMillis());
        user.setCreated(d);
        user.setUpdated(d);
        return repository.save(user);
    }
    @Override
    public ResultWrapper exit(){
        String token = (String) SecurityUtils.getSubject().getPrincipal();

        Integer userId = JwtUtils.getUserId(token);
        // 到期时间
        redisTemplate.expire("token:userId:" + userId, 0, TimeUnit.MILLISECONDS);
        return ResultWrapper.success("退出成功") ;
    }
}
