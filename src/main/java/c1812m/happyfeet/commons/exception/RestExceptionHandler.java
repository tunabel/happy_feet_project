package c1812m.happyfeet.commons.exception;

import c1812m.happyfeet.commons.response.BaseApiResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(CustomNotFoundException.class)
    public BaseApiResult CustomNotFoundExceptionHandler(CustomNotFoundException exception) {
        return new BaseApiResult(false, "Item not found");
    }

}
