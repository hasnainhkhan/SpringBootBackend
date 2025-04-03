package com.smart.contact.configuration;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class UsernamePasswordAuthenticationTokenSerializer implements RedisSerializer<UsernamePasswordAuthenticationToken> {

    @Override
    public byte[] serialize(UsernamePasswordAuthenticationToken token) throws SerializationException {
        if (token == null) {
            return new byte[0];
        }
        // Convert fields of UsernamePasswordAuthenticationToken to a serializable object (like a string)
        return (token.getPrincipal().toString() + ":" + token.getCredentials().toString()).getBytes();
    }

    @Override
    public UsernamePasswordAuthenticationToken deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        // Deserialize the byte array back into a UsernamePasswordAuthenticationToken
        String data = new String(bytes);
        String[] parts = data.split(":");
        if (parts.length != 2) {
            throw new SerializationException("Invalid data for deserialization");
        }
        return new UsernamePasswordAuthenticationToken(parts[0], parts[1], AuthorityUtils.NO_AUTHORITIES);
    }
}
