package pl.polsl.telinf.s3.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.telinf.s3.domain.model.user.User;

import java.util.Optional;

@Repository
public interface JPAUserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
