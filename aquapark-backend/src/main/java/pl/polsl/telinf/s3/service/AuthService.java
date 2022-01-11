package pl.polsl.telinf.s3.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.polsl.telinf.s3.domain.dto.exception.UnmatchedPasswordsException;
import pl.polsl.telinf.s3.domain.dto.exception.UserAlreadyExistsException;
import pl.polsl.telinf.s3.domain.dto.UserDto;
import pl.polsl.telinf.s3.domain.model.user.User;
import pl.polsl.telinf.s3.repository.jpa.JPAUserRepository;
import pl.polsl.telinf.s3.repository.jpa.JPAUserTypeRepository;

import static java.lang.String.format;

@Service
public class AuthService implements UserDetailsService {
    JPAUserRepository userRepository;
    JPAUserTypeRepository userTypeRepository;
    PasswordEncoder passwordEncoder;

    public AuthService(JPAUserRepository userRepository, JPAUserTypeRepository userTypeRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException(format("User with username - %s, not found", username))
                );
    }

    public User register(UserDto userDto) throws UserAlreadyExistsException, UnmatchedPasswordsException {

        if(checkIfUserAlreadyExists(userDto.getEmail(), userRepository)) {
            throw new UserAlreadyExistsException();
        }
        if(!checkIfPasswordsAreSame(userDto))
            throw new UnmatchedPasswordsException();

        return userRepository.save(userDto.toUser(this.userTypeRepository, this.passwordEncoder));
    }

    private static boolean checkIfPasswordsAreSame(UserDto userDto) {
        return userDto.getPassword().equals(userDto.getRepeatedPassword());
    }

    private static boolean checkIfUserAlreadyExists(String email, JPAUserRepository userRepository) {
        return userRepository.findByEmail(email).isPresent();
    }
}
