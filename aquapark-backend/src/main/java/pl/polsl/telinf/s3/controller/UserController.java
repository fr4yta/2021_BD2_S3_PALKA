package pl.polsl.telinf.s3.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.polsl.telinf.s3.domain.dto.UserUpdateDto;
import pl.polsl.telinf.s3.domain.dto.exception.CustomException;
import pl.polsl.telinf.s3.service.UserService;
import pl.polsl.telinf.s3.domain.model.user.User;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping(path = "/delete")
    public ResponseEntity deleteUser(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String token) {
        userService.deleteUser(token);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(path="/edit")
    @Transactional
    public ResponseEntity updateUserPassword(@RequestHeader(name = HttpHeaders.AUTHORIZATION)String token,
                                             @RequestBody UserUpdateDto userUpdateDto) throws CustomException {
        userService.changeUserPassword(token, userUpdateDto);
        return ResponseEntity.noContent().build();
    }

}
