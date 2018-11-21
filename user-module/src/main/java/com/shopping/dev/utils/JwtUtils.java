package com.shopping.dev.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 * @author:毕胜朋
 * @date:2018/11/1 11:40
 */

public class JwtUtils {
    /**
     * 默认过期时间30分钟
     *
     * @param userId
     * @return token
     */
    public static String newToken(Long userId) {
        return newToken(userId, Constants.DEFAULT_EXPIRED_SECONDS);
    }


    /**
     * @param userId
     * @param expiredSecond 过期时长
     * @return token
     */

    public static String newToken(Long userId, long expiredSecond) {
        return JWT.create()
                .withClaim("userId", userId)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + expiredSecond * 1000))
                .sign(Algorithm.HMAC256(Constants.SECRET_KEY));
    }

    /**
     * 校验token是否合法
     *
     * @param token 需要校验的token
     * @return 是否合法
     */
    public static boolean checkToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(Constants.SECRET_KEY)).
                build();
        try {
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 刷新token
     *
     * @param token 原token
     * @return 新token
     */
    public static String refreshToken(String token) {
        // 解码头和负载
        DecodedJWT jwt = JWT.decode(token);
    Long userId = jwt.getClaim("userId").asLong();
        return newToken(userId);
//        // 获取负载
//        String payload = jwt.getPayload();
//        byte[] bytes = Base64.getDecoder().decode(payload);
//        String json = bytes.toString();
//        System.out.println(json);
//        // 返回新的token
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            Payload pl = mapper.readValue(json, Payload.class);
//            Long userId = pl.getUserId();
//            return newToken(userId);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    /**
     * 校验token是否合法, 合法后持续时间过没过百分之80
     * @param token
     * @return
     */
    public static String autoRequire(String token) {
//        检查是否合法
        boolean check = checkToken(token);
        if (check) {
            DecodedJWT jwt = JWT.decode(token);
            // 计算时间是否超过80%
            long current = System.currentTimeMillis() / 1000;
            Long start = jwt.getClaim("iat").asLong();
            Long end = jwt.getClaim("exp").asLong();
            if ((current - end) * 1.0 / (end - start) > 0.8) {
                return refreshToken(token);
            } else {
                return token;
            }
        } else {
            throw new JWTVerificationException("token不合法");
        }
    }
    public static  Integer getUserId(String jwtToken){
        System.out.println("jetToken"+jwtToken);
        return JWT.decode(jwtToken).getClaim("userId").asInt();
    }

}
