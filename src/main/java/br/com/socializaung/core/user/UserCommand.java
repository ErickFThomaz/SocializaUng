package br.com.socializaung.core.user;

import br.com.socializaung.core.auth.login.SignupResource;
import br.com.socializaung.core.exception.UserConflictException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserCommand {

    private final UserRepository repository;

    public User create(SignupResource resource){
        Optional<User> byEmail = repository.findByEmail(resource.getEmail());

        if(byEmail.isPresent()){
            throw new UserConflictException("Já existe um usuário com este email.");
        }

        return repository.save(User.builder()
                .email(resource.getEmail())
                .type(resource.getType())
                .name(resource.getName())
                .password(resource.getPassword()).build()
                .encryptPassword());
    }
}
