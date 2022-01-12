package pl.polsl.telinf.s3.domain.dto;

import lombok.Value;

@Value
public class JwtTokenDto {
    private String jwtToken;
    private String userId;
    private String userRole;
}
