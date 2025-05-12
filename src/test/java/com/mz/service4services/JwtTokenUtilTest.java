package com.mz.service4services;

import com.mz.service4services.security.JwtTokenUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JwtTokenUtilTest {

    private JwtTokenUtil jwtTokenUtil;
    private final Integer testUserId = 123;

    @BeforeEach
    public void setUp() {
        jwtTokenUtil = new JwtTokenUtil();
    }

    @Test
    public void testGenerateAndValidateAccessToken() {
        String token = jwtTokenUtil.generateAccessToken(testUserId);
        assertNotNull(token);
        assertTrue(jwtTokenUtil.validateToken(token));
    }

    @Test
    public void testGenerateAndValidateRefreshToken() {
        String token = jwtTokenUtil.generateRefreshToken(testUserId);
        assertNotNull(token);
        assertTrue(jwtTokenUtil.validateToken(token));
    }

    @Test
    public void testGetIdFromToken() {
        String token = jwtTokenUtil.generateAccessToken(testUserId);
        String subject = jwtTokenUtil.getIdFromToken(token);
        assertEquals(String.valueOf(testUserId), subject);
    }

    @Test
    public void testInvalidToken() {
        String invalidToken = "invalid.token.value";
        assertFalse(jwtTokenUtil.validateToken(invalidToken));
    }

    @Test
    public void testExpiredToken() throws InterruptedException {
        jwtTokenUtil = new JwtTokenUtil() {
            {
                this.accessTokenValidity = 1000; // 1 sekunda
            }
        };

        String token = jwtTokenUtil.generateAccessToken(testUserId);
        Thread.sleep(1500); // poczekaj aż wygaśnie
        assertFalse(jwtTokenUtil.validateToken(token));
    }
}
