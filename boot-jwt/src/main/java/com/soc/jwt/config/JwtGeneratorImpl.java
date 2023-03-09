package com.soc.jwt.config;

import com.soc.jwt.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class JwtGeneratorImpl implements JwtGeneratorInterface {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${app.jwttoken.message}")
    private String message;

    @Override
    public Map<String, String> generateToken(User user) {
        String jwttoken = "";
        jwttoken = Jwts.builder().setSubject(user.getUserName())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secret")
                .compact();

        Map<String, String> jwtTokenGen = new HashMap<>();
        jwtTokenGen.put("token", jwttoken);
        jwtTokenGen.put("message", message);
        return jwtTokenGen;
    }
}
