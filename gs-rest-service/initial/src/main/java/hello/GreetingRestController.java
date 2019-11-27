package hello;

import java.util.concurrent.atomic.AtomicLong;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greetingrest", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(value = "/freejwt", method = RequestMethod.GET)
    public ResponseEntity<String> freejwt(@RequestParam(value="name", defaultValue="World") String name) {

        try {
            Algorithm algorithm = Algorithm.HMAC256("wow very secret");
            String token = JWT.create()
                    .withIssuer("I did it")
                    .withClaim("Bob", "Jean")
                    .withClaim("counter", counter.incrementAndGet())
                    .sign(algorithm);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", token);

            return new ResponseEntity<String>("Bonjour", headers, HttpStatus.OK);


        } catch (JWTCreationException exception){
            return new ResponseEntity<String>("Non!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}