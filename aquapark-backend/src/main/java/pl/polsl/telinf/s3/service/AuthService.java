package pl.polsl.telinf.s3.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.polsl.telinf.s3.repository.jpa.JPAUserRepository;

import static java.lang.String.format;

@Service
public class AuthService implements UserDetailsService {
    JPAUserRepository userRepository;

    public AuthService(JPAUserRepository userRepository) {
        this.userRepository = userRepository;
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
