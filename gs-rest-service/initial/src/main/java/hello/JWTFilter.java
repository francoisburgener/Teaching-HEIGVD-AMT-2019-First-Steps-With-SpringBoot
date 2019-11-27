package hello;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// This was a funny experiment
// @Component
public class JWTFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;


        String token = request.getHeader("Authorization");

        if(token != null) {
            try {
                Algorithm algorithm = Algorithm.HMAC256("wow very secret");
                JWTVerifier verifier = JWT.require(algorithm)
                        .withIssuer("I did it")
                        .build(); //Reusable verifier instance
                DecodedJWT jwt = verifier.verify(token);

                System.out.print("aaaaaaa");
            } catch (JWTVerificationException exception){
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);

                return;
            }
            chain.doFilter(req, resp);
        }

        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
