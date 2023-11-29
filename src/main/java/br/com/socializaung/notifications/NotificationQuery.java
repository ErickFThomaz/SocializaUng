package br.com.socializaung.notifications;

import br.com.socializaung.core.user.UserQuery;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NotificationQuery {

    private final UserQuery userQuery;

    private final NotificationRepository repository;

    public List<Notification> findAll(){
        return repository.findAllByToUser(userQuery.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()));
    }
}
