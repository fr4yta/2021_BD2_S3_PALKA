package pl.polsl.telinf.s3.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pl.polsl.telinf.s3.domain.dto.UserUpdateDto;
import pl.polsl.telinf.s3.domain.dto.exception.CustomException;
import pl.polsl.telinf.s3.service.UserService;
import pl.polsl.telinf.s3.domain.model.user.User;
import pl.polsl.telinf.s3.security.JwtTokenUtil;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
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

    @DeleteMapping
    public ResponseEntity deleteUser(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String token) {
        userService.deleteUser(token);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping
    @Transactional
    public ResponseEntity updateUserPassword(@RequestHeader(name = HttpHeaders.AUTHORIZATION)String token,
                                             @RequestBody UserUpdateDto userUpdateDto) throws CustomException {
        userService.changeUserPassword(token, userUpdateDto);
        return ResponseEntity.noContent().build();
    }

}
