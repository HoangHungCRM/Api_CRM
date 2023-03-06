package com.resdii.crm.user.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class JwtConfig {
    @Value("${jwt.secret:}")
    private String jwtSecret;

    @Value("${jwt.email-verification.type:}")
    private String emailVerificationType;

    @Value("${jwt.email-verification.durationInSeconds:}")
    private Long emailVerificationDuration;
}
