package c1812m.happyfeet.commons.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity CustomNotFoundExceptionHandler(CustomNotFoundException exception) {
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ItemDuplicationException.class)
    public ResponseEntity ItemDuplicationExceptionHandler(ItemDuplicationException exception) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomBadRequestException.class)
    public ResponseEntity CustomBadRequestExceptionHandler(CustomBadRequestException exception) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
