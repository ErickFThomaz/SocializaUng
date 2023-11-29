package br.com.socializaung.post;

import br.com.socializaung.core.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findAllByUser(User user);
}
