package pl.polsl.telinf.s3.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.polsl.telinf.s3.domain.dtoTODO.UserAlreadyExistsException;
import pl.polsl.telinf.s3.domain.dtoTODO.UserDto;
import pl.polsl.telinf.s3.domain.model.user.User;
import pl.polsl.telinf.s3.repository.jpa.JPAUserRepository;
import pl.polsl.telinf.s3.repository.jpa.JPAUserTypeRepository;
import pl.polsl.telinf.s3.security.Role;

import static java.lang.String.format;

@Service
public class AuthService implements UserDetailsService {
    JPAUserRepository userRepository;
    JPAUserTypeRepository userTypeRepository;

    public AuthService(JPAUserRepository userRepository, JPAUserTypeRepository userTypeRepository) {
        this.userRepository = userRepository;
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException(format("User with username - %s, not found", username))
                );
    }

    public User register(UserDto userDto) throws UserAlreadyExistsException {

        if(checkIfUserAlreadyExists(userDto.getEmail())) {
            throw new UserAlreadyExistsException();
        }
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setUsername(user.getUsername());
        user.setUserType(userTypeRepository.findUserTypeByUserTypeContains(Role.USER).orElse(null));
        userRepository.save(user);
        return user;
    }

    //TODO
    private static boolean checkIfUserAlreadyExists(String email) {
        return false;
    }
}
