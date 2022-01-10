package pl.polsl.telinf.s3.domain.dto.exception;

public class UserAlreadyExistsException extends CustomException {

 public String getMessage() {
  return "Dany użytkownik już istnieje!";
 }
}
