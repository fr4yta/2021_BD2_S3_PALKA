package pl.polsl.telinf.s3.domain.dtoTODO;

import lombok.Value;

@Value
public class AuthRequest {
    private String username;
    private String password;
}
