package br.com.socializaung.core.auth.login.web;

import br.com.socializaung.core.auth.JwtUtil;
import br.com.socializaung.core.auth.login.LoginResource;
import br.com.socializaung.core.auth.login.LoginResponseResource;
import br.com.socializaung.core.auth.login.SignupResource;
import br.com.socializaung.core.exception.PasswordNotEqualsException;
import br.com.socializaung.core.user.User;
import br.com.socializaung.core.user.UserCommand;
import br.com.socializaung.core.user.UserQuery;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/auth")
public class AuthenticationRestService {

    private final JwtUtil jwtUtil;

    private final UserQuery userQuery;

    private final UserCommand userCommand;

    private final AuthenticationManager authenticationManager;


   @PostMapping("/login")
    public ResponseEntity<LoginResponseResource> login(@RequestBody LoginResource loginReq)  {

            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getEmail(), loginReq.getPassword()));
            String email = authentication.getName();

            String token = jwtUtil.createToken(userQuery.findByEmail(email));
            LoginResponseResource loginRes = new LoginResponseResource(token);

            return ResponseEntity.ok(loginRes);
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignupResource signupResource)  {

       if(signupResource.isPasswordNotEquals()){
           throw new PasswordNotEqualsException("As senhas não estão identicas.");
       }

       return ResponseEntity.status(CREATED).body(userCommand.create(signupResource));
    }



}
