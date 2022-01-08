package pl.polsl.telinf.s3.controller;

import org.springframework.http.HttpHeaders;
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
import pl.polsl.telinf.s3.domain.dtoTODO.AuthRequest;
import pl.polsl.telinf.s3.domain.dtoTODO.UserDto;
import pl.polsl.telinf.s3.domain.model.user.User;
import pl.polsl.telinf.s3.security.JwtTokenUtil;
import pl.polsl.telinf.s3.service.AuthService;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/auth")
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
    public ResponseEntity<String> login(@RequestBody @Valid AuthRequest request) {
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    request.getUsername(), request.getPassword()
                            )
                    );

            User user = (User) authenticate.getPrincipal();

            return ResponseEntity.ok()
                    .header(
                            HttpHeaders.AUTHORIZATION,
                            jwtTokenUtil.generateAccessToken(user)
                    ).build();
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).header(HttpHeaders.WARNING, ex.getMessage()).build();
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().header(HttpHeaders.WARNING, e.getMessage()).build();
        }
    }

    @PostMapping(path = "/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid UserDto userDto) {
        try {
            User created = authService.register(userDto);
        }
        catch (Exception ex){
            ResponseEntity.badRequest().header(HttpHeaders.WARNING, ex.getMessage()).build();
        }
        return ResponseEntity.ok().build();
    }
}
