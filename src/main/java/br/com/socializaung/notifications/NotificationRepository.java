package br.com.socializaung.notifications;

import br.com.socializaung.core.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

interface NotificationRepository extends MongoRepository<Notification, String> {

    List<Notification> findAllByToUser(User toUser);
}
