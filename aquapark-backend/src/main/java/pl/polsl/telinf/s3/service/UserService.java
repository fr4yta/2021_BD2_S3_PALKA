package pl.polsl.telinf.s3.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.polsl.telinf.s3.domain.model.user.User;
import pl.polsl.telinf.s3.repository.jpa.JPAUserRepository;

import java.util.List;

import static java.lang.String.format;

@Service
public class UserService implements UserDetailsService {
    private JPAUserRepository userRepository;

    public UserService(JPAUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException(format("User with username - %s, not found", username))
                );
    }
}
