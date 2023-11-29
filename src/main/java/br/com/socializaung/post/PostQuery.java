package br.com.socializaung.post;

import br.com.socializaung.core.user.User;
import br.com.socializaung.core.user.UserQuery;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostQuery {

    private final UserQuery userQuery;

    private final PostRepository repository;

    public List<Post> findAllPosts(){
        return repository.findAll();
    }

    public List<Post> findMyAllPosts(){
        User user = userQuery.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        return repository.findAllByUser(user);
    }
}
