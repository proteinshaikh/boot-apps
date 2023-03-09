package com.soc.jwt.config;

import com.soc.jwt.model.User;

import java.util.Map;

public interface JwtGeneratorInterface {

    Map<String, String> generateToken(User user);
}
