package com.shopping.dev.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.text.SimpleDateFormat;

/**
 * @author:毕胜朋
 * @date:2018/10/30 17:18
 */

@Configuration
public class RedisConfig {
    //    第一个泛型是key的类型, 第二个是value的类型
//    默认的bean的id是方法名
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<Object, Object> template
                = new RedisTemplate<>();
        //配置连接工厂, 否则不能创建RedisTemplate的bean
        template.setConnectionFactory(factory);

        Jackson2JsonRedisSerializer<Object> valueSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
//        定制Jackson
        ObjectMapper mapper = new ObjectMapper();
//        配置时间序列化方式, 其他的序列化方式, 自己查, 比如对象为Null的时候是否序列化
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
//        定制Jackson
        valueSerializer.setObjectMapper(mapper);
        template.setValueSerializer(valueSerializer);
//        该方法的意思就是, 这个RedisTemplate也会加载springboot中的对应的Redis配置
        //        序列化key, 把object的对象, 序列化为字符串的类型
//        该方法的意义是, 定义如何序列化可以
        template.setKeySerializer(valueSerializer);
        template.afterPropertiesSet();
        return template;
    }
}
