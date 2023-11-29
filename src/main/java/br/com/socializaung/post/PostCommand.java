package br.com.socializaung.post;

import br.com.socializaung.core.user.User;
import br.com.socializaung.core.user.UserQuery;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostCommand {

    private final UserQuery userQuery;

    private final PostRepository repository;


    public Post create(Post post){
        User user = userQuery.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        return repository.save(post.withUser(user));
    }
}
