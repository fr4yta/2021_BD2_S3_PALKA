package pl.polsl.telinf.s3.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.telinf.s3.domain.dto.AuthRequest;
import pl.polsl.telinf.s3.domain.dto.JwtTokenDto;
import pl.polsl.telinf.s3.domain.dto.UserDto;
import pl.polsl.telinf.s3.domain.dto.exception.CustomException;
import pl.polsl.telinf.s3.domain.dto.exception.CustomExceptionResponse;
import pl.polsl.telinf.s3.domain.model.user.User;
import pl.polsl.telinf.s3.security.JwtTokenUtil;
import pl.polsl.telinf.s3.service.AuthService;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(path = "/api/auth")
@Validated
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthService authService;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, AuthService authService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    request.getUsername(), request.getPassword()
                            )
                    );

            User user = (User) authenticate.getPrincipal();
            JwtTokenDto token = new JwtTokenDto(jwtTokenUtil.generateAccessToken(user), String.valueOf(user.getId()),
                    user.getUserType().getAuthority());
            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, token.getJwtToken())
                    .body(token);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new CustomExceptionResponse(e.getMessage()));
        }
    }

    @PostMapping(path = "/register")
    public ResponseEntity<User> register(@RequestBody @Valid UserDto userDto) throws CustomException {
        User created = authService.register(userDto);
        URI location = URI.create(String.format("/api/users/%s", created.getId()));
        return ResponseEntity.created(location).body(created);
    }
}
