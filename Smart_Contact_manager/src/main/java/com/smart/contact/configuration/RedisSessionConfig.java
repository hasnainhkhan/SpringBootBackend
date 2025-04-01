package com.smart.contact.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

import lombok.extern.slf4j.Slf4j;
@Slf4j @Configuration @EnableRedisHttpSession
public class RedisSessionConfig {
	
	public CookieSerializer cookieSerializer() {
		DefaultCookieSerializer serializer = new DefaultCookieSerializer();
		serializer.setCookieName("SESSIONID");
		serializer.setDomainName("^.+?\\.(\\w+\\.[a-z]+)$");
		log.info(serializer+" ");
		return serializer;
		
	}
}
