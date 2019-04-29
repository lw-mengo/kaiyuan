package com.kaiyuan.mengo.kaiyuan.utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.ServletException;
import java.util.Date;

public class JwtUtil {

    private static final String BASE_KEY = "650871de1d5250d3aaf77ed21c5d7a3806427f6a8de217490fab4927e0019e3e";//私钥
    private static long TOKEN_EXP = 1000 * 60 * 30;//过期时间，?分钟

    public static String getToken(String userName) {
        return Jwts.builder()
                .setSubject(userName)
                .claim("roles", "user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXP))  /*过期时间*/
                .signWith(SignatureAlgorithm.HS256,BASE_KEY)
                .compact();

    }

    public static Claims checkToken(String token) throws ServletException {
        try {
            final Claims claims = Jwts.parser().setSigningKey(BASE_KEY).parseClaimsJws(token).getBody();
            return claims;
        } catch (ExpiredJwtException e) {
            throw new ServletException("10002");//token过期
        } catch (Exception e) {
            throw new ServletException("10001");//未登录
        }
    }

}

