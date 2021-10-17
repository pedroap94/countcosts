package br.com.countcosts.countcosts.handler;

import br.com.countcosts.countcosts.exception.MethodArgumentTypeMismatchExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<MethodArgumentTypeMismatchExceptionDetails> handlerMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        return new ResponseEntity<>(MethodArgumentTypeMismatchExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Bad Request. Wrong type of argument")
                .developerMessage(ex.getClass().getName())
                .build(), HttpStatus.BAD_REQUEST);
    }
}
