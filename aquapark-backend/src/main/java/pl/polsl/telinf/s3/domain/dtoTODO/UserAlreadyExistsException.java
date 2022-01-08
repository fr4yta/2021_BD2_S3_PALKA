package pl.polsl.telinf.s3.domain.dtoTODO;

public class UserAlreadyExistsException extends Exception {

 @Override
 public String getMessage() {
  return "User Already Exists!";
 }
}
