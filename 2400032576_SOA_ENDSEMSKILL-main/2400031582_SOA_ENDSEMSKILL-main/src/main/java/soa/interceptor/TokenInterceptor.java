
package soa.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Value("${tourism.api.token}")
    private String validToken;

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {

        String incomingToken =
                request.getHeader("X-Auth-Token");

        // Check missing token
        if (incomingToken == null || incomingToken.isBlank()) {

            response.setStatus(
                HttpServletResponse.SC_UNAUTHORIZED
            );

            response.setContentType("application/json");
            response.getWriter().write(
                "{\"error\":\"Unauthorized: Token missing\"}"
            );

            return false;
        }

        // Validate token
        boolean isValid = MessageDigest.isEqual(
            incomingToken.getBytes(StandardCharsets.UTF_8),
            validToken.getBytes(StandardCharsets.UTF_8)
        );

        if (!isValid) {

            response.setStatus(
                HttpServletResponse.SC_UNAUTHORIZED
            );

            response.setContentType("application/json");
            response.getWriter().write(
                "{\"error\":\"Unauthorized: Invalid token\"}"
            );

            return false;
        }

        // Token is valid
        return true;
    }
}
