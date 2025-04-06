package com.smart.contact.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(org.springframework.data.redis.connection.RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        // Set custom serializer for values in Redis
        template.setValueSerializer(new UsernamePasswordAuthenticationTokenSerializer());

        // Optionally, you can also set the default key serializer if needed
        template.setKeySerializer(new org.springframework.data.redis.serializer.StringRedisSerializer());

        return template;
    }
}
