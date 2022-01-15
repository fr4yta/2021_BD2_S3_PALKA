package pl.polsl.telinf.s3.domain.dto;

import lombok.Data;

@Data
public class UserUpdateDto {
    private String newPassword;
    private String oldPassword;
    private String oldRepeatedPassword;
}
