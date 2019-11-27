package hello;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JWTInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");

        try {
            Algorithm algorithm = Algorithm.HMAC256("wow very secret");
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("I did it")
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);


            return true;

        } catch (JWTVerificationException | NullPointerException exception){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return false;

        }
    }
}

