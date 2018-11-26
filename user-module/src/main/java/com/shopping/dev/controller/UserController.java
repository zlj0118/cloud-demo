package com.shopping.dev.controller;
import com.shopping.dev.entity.User;
import com.shopping.dev.service.UserService;
import com.shopping.dev.shiro.SimpleUsernameToken;
import com.shopping.dev.utils.ResultWrapper;
import org.apache.shiro.SecurityUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author:毕胜朋
 * @date:2018/11/12 11:28
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private UserService service;

    /**
     * 注册把数据插入数据库
     *
     * @param user
     * @return
     */
    @RequestMapping("/register")
    public ResultWrapper add(@Validated User user, BindingResult result) {
        // 注册后台校验, 遍历所有不符合校验的信息,拼接成字符串
        ResultWrapper sb = getResultWrapper(result);
        if (sb != null) return sb;
        service.addAll(user);
        return ResultWrapper.success(null);
    }

    private ResultWrapper getResultWrapper(BindingResult result) {
        if (result.hasFieldErrors()) {
            StringBuilder sb = new StringBuilder();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors) {
                String errorDefaultMessage = error.getDefaultMessage();
                sb.append(errorDefaultMessage);
            }
            return ResultWrapper.error(405, sb.toString());
        }
        return null;
    }

    /**
     * 注册
     * 一些简单校验
     *
     * @param user
     * @return
     */
    @RequestMapping("/check")
    public ResultWrapper check(User user) {
        User loginUser = service.findUserByPhoneOrUsername(user);
        if (loginUser != null) {
            return ResultWrapper.error(401, "已存在");
        } else {
            return ResultWrapper.success(null);
        }
    }

    /**
     * 登录
     *
     * @param
     * @param
     * @return
     */
    @RequestMapping("/login")
    public ResultWrapper login(@Validated User user, BindingResult result) {
        // 判断校验是否有问题
        ResultWrapper sb = getResultWrapper(result);
        if (sb != null) return sb;
        // token 中存用户名密码 用来校验登录 时用户名密码
        SimpleUsernameToken token = new SimpleUsernameToken(user.getUsername(), user.getPassword());

        //信息返回给客户端，同时将登录用户的信息传递给Realm进行登录验证。
        SecurityUtils.getSubject().login(token);

        String jwtToken = (String) SecurityUtils.getSubject().getPrincipal();

        Map<String, Object> map = new HashMap<>();
        map.put("token", jwtToken);
        map.put("User", user);
        User user1 = this.service.findByUsername(user);
//      防止一个用户多次登录, 在Redis中一个key产生value
        redisTemplate.delete("token:userId:" + user1.getId());
        ValueOperations opsValue = redisTemplate.opsForValue();

        opsValue.set("token:userId:" + user1.getId(), jwtToken);
        return ResultWrapper.success(map);
    }

    @RequestMapping("/logout")
    public ResultWrapper logout() {
        ResultWrapper exit = service.exit();
        return exit;
    }
}