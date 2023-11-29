package br.com.socializaung.core.exception;

public class UserConflictException extends RuntimeException {


    public UserConflictException(String description){
        super(description);
    }
}
