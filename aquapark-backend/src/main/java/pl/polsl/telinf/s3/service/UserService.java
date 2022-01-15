package pl.polsl.telinf.s3.service;
import org.springframework.stereotype.Service;
import pl.polsl.telinf.s3.domain.dto.UserUpdateDto;
import pl.polsl.telinf.s3.domain.dto.exception.CustomException;
import pl.polsl.telinf.s3.domain.dto.exception.DataNotFoundException;
import pl.polsl.telinf.s3.domain.dto.exception.UnmatchedPasswordsException;
import pl.polsl.telinf.s3.domain.model.user.User;
import pl.polsl.telinf.s3.repository.jpa.JPAUserRepository;
import pl.polsl.telinf.s3.security.JwtTokenUtil;

import java.util.List;

@Service
public class UserService {
    private JPAUserRepository userRepository;
    private JwtTokenUtil jwtTokenUtil;

    public UserService(JPAUserRepository userRepository, JwtTokenUtil jwtTokenUtil) {
        this.userRepository = userRepository;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void deleteUser(String token) {
        userRepository.deleteById(Integer.valueOf(jwtTokenUtil.getUserId(modifyUserToken(token))));
        //TODO
        //delete all user's purchases too!
    }

    public void changeUserPassword(String token, UserUpdateDto userUpdateDto) throws CustomException {
        if(!checkIfOldPasswordIsCorrect(userUpdateDto.getNewPassword(), userUpdateDto.getOldRepeatedPassword()))
            throw new UnmatchedPasswordsException();
        User user = userRepository.findById(Integer.valueOf(jwtTokenUtil.getUserId(modifyUserToken(token))))
                .orElseThrow(DataNotFoundException::new);
        if(!user.getPassword().equals(userUpdateDto.getOldPassword()))
            throw new UnmatchedPasswordsException();

        user.setPassword(userUpdateDto.getNewPassword());
    }

    public boolean checkIfOldPasswordIsCorrect(String password, String passwordToCheck) {
        return password.equals(passwordToCheck);
    }

    public String modifyUserToken(String token) {
        return token.replace("Bearer ", "");
    }
}
