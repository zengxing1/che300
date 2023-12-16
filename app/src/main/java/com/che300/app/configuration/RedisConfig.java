package com.che300.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author caijiangfan
 * @version 1.0.0
 * @ClassName RedisConf.java
 * @Description TODO
 * @createTime 2023/12/15 09:58
 */

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> redistemplate = new RedisTemplate<>();
        redistemplate.setKeySerializer(new StringRedisSerializer());
        redistemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redistemplate.setHashKeySerializer(new StringRedisSerializer());
        redistemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        redistemplate.setConnectionFactory(factory);
        return redistemplate;
    }


}
