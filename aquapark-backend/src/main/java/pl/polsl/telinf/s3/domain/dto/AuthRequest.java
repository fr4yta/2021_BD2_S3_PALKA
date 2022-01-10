package pl.polsl.telinf.s3.domain.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
