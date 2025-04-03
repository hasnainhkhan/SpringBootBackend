package com.smart.contact.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.data.redis.RedisSessionRepository;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {

    @Bean
    public RedisSessionRepository sessionRepository(RedisTemplate<String, Object> redisTemplate) {
        RedisSessionRepository sessionRepository = new RedisSessionRepository(redisTemplate);
        // You can configure session expiration and other session-related settings here
        return sessionRepository;
    }
}
