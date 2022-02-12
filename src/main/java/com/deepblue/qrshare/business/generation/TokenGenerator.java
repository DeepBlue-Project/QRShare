package com.deepblue.qrshare.business.generation;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.apache.commons.lang3.RandomStringUtils;

public class TokenGenerator {

    public String generateToken() {
        Algorithm algorithm = Algorithm.HMAC256(RandomStringUtils.randomAlphabetic(20));
        return JWT.create()
            .withIssuer("auth0")
            .sign(algorithm);
    }
}
