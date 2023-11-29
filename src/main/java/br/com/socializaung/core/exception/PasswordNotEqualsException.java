package br.com.socializaung.core.exception;

public class PasswordNotEqualsException extends RuntimeException {

    public PasswordNotEqualsException(String description){
        super(description);
    }
}
