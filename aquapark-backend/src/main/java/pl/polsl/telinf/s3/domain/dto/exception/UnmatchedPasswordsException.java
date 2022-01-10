package pl.polsl.telinf.s3.domain.dto.exception;

public class UnmatchedPasswordsException extends Exception {
    @Override
    public String getMessage() {
        return "Passwords must be the same!";
    }
}
