package pl.polsl.telinf.s3.domain.dto;

import lombok.Data;
import pl.polsl.telinf.s3.domain.model.user.User;
import pl.polsl.telinf.s3.repository.jpa.JPAUserTypeRepository;
import pl.polsl.telinf.s3.security.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.Instant;

@Data
public class UserDto {
    @NotEmpty
    @NotNull
    private String username;
    @Email
    private String email;
    @NotEmpty
    @NotNull
    private String password;
    @NotEmpty
    @NotNull
    private String repeatedPassword;
    private String firstName;
    private String lastName;

    public User toUser(JPAUserTypeRepository userTypeRepository) {
        User user = new User();

        user.setUsername(this.username);
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setUserType(userTypeRepository.findUserTypeByUserTypeContains(Role.USER).orElse(null));
        user.setCreateTime(Timestamp.from(Instant.now()));

        return user;
    }
}
