package br.com.socializaung.core.exception.controller;

import br.com.socializaung.core.exception.PasswordNotEqualsException;
import br.com.socializaung.core.exception.UserConflictException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(1)
public class ExceptionController {


    @ExceptionHandler(PasswordNotEqualsException.class)
    public ResponseEntity<MessageException> passwordNotEqualsException(PasswordNotEqualsException passwordNotEqualsException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageException(passwordNotEqualsException.getMessage()));
    }

    @ExceptionHandler(UserConflictException.class)
    public ResponseEntity<MessageException> userConflictException(UserConflictException userConflictException){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageException(userConflictException.getMessage()));
    }
}
