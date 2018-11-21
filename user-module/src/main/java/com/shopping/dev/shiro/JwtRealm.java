package com.shopping.dev.shiro;
import com.shopping.dev.utils.JwtUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author:毕胜朋
 * @date:2018/11/6 9:44
 */
@Component
public class JwtRealm extends SimpleRealm {

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public String getName() {
        return "jwtRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        // 如果使用jwtToken
        // 那么就由该realm处理登录逻辑
        return  token instanceof JwtToken;
    }
    // 验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//         拿到用户名
        String jwtToken = (String) token.getPrincipal();
        Integer userId = JwtUtils.getUserId(jwtToken);

        try {
            // 从redis里把这个用户的token取出来
            // 与用户传递过来的token做对比
            ValueOperations valueOperations = redisTemplate.opsForValue();
            String redisToken = (String) valueOperations.get("token:userId:" + userId);
            if (jwtToken.equals(redisToken)) {
                String newToken = JwtUtils.autoRequire(jwtToken);
                SimpleAuthenticationInfo info =
                        new SimpleAuthenticationInfo(newToken,newToken,getName());
                return info;
            } else {
                throw new AuthenticationException("请从新登录");
            }

        } catch (Exception e) {
            throw new AuthenticationException("请从新登录");

        }

    }
}
