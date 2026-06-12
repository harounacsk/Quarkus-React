package org.hrn.service;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import org.hrn.dto.TokenResponse;
import org.hrn.entity.User;

import java.time.Duration;
import java.util.Set;

@ApplicationScoped
public class JwtService {
    public TokenResponse generate(User user) {
       TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.token = Jwt.issuer("quarkus-app")
                .upn(user.email)
                .groups(Set.of(user.role))
                .issuer("https://example.com/issuer")
                .expiresIn(Duration.ofHours(1))
                .sign();
        return  tokenResponse;
    }
}
