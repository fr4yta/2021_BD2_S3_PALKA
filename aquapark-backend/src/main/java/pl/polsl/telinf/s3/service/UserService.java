package pl.polsl.telinf.s3.service;
import org.springframework.stereotype.Service;
import pl.polsl.telinf.s3.domain.model.user.User;
import pl.polsl.telinf.s3.repository.jpa.JPAUserRepository;

import java.util.List;

@Service
public class UserService {
    private JPAUserRepository userRepository;

    public UserService(JPAUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
