package pl.polsl.telinf.s3.domain.dto.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseEntity<CustomExceptionResponse> handleException(CustomException ex) {
        return ResponseEntity.badRequest().body(new CustomExceptionResponse(ex.getMessage()));
    }
}
