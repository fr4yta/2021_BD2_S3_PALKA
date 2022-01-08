package pl.polsl.telinf.s3.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.telinf.s3.domain.model.user.UserType;

import java.util.Optional;

@Repository
public interface JPAUserTypeRepository extends JpaRepository<UserType, Integer> {
    Optional<UserType> findUserTypeByUserTypeContains(String userType);
}
