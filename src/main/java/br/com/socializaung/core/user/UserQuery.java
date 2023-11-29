package br.com.socializaung.core.user;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static br.com.socializaung.core.user.UserType.ONG;

@Service
@AllArgsConstructor
//@Transactional(readOnly = true)
public class UserQuery {

    private final UserRepository userRepository;


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email).orElse(null);
    }

    public List<User> findByName(String email){
        return userRepository.findAllByNameLikeAndType(email, ONG);
    }

}
