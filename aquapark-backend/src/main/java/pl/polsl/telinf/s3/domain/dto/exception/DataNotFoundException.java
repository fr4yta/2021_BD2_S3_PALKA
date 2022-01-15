package pl.polsl.telinf.s3.domain.dto.exception;

public class DataNotFoundException extends CustomException {
    public String getMessage() {
        return "Nie znaleziono obiektu!";
    }
}
