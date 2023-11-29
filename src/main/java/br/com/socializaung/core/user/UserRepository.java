package br.com.socializaung.core.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(@Email String email);

    List<User> findAllByNameLikeAndType(@NotEmpty String name, UserType type);
}
