package pl.polsl.telinf.s3.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pl.polsl.telinf.s3.service.UserService;
import pl.polsl.telinf.s3.domain.model.user.User;
import pl.polsl.telinf.s3.security.JwtTokenUtil;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class UserContorller {
    private final UserService userService;

    public UserContorller(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){
        return ResponseEntity.ok(userService.findAll());
    }

}
