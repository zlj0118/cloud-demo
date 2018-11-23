package com.shopping.dev.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.text.SimpleDateFormat;

/**
 * 创建 JYQ  on  2018/11/8,15:24
 */
@Configuration
public class RedisConfig1 {
    @Bean
//    容器中拿到Redis链接工厂
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<Object,Object> template = new RedisTemplate<>();

        template.setConnectionFactory(factory);
         template.setKeySerializer(new StringRedisSerializer());
        Jackson2JsonRedisSerializer<Object> jsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        // 定制Jackson格式  对象值为null属性是否序列化,或者更美观的json格式
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        jsonRedisSerializer.setObjectMapper(mapper);
//        template.setKeySerializer(jsonRedisSerializer);
        template.setValueSerializer(jsonRedisSerializer);
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer( new StringRedisSerializer());
        template.afterPropertiesSet();
        return template;

    }
}

