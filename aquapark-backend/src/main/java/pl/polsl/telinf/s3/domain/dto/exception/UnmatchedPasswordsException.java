package pl.polsl.telinf.s3.domain.dto.exception;

public class UnmatchedPasswordsException extends CustomException {

    public String getMessage() {
        return "Hasła muszą być takie same!";
    }
}
