package pl.polsl.telinf.s3.domain.dtoTODO;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
}
