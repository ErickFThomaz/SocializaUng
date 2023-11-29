package br.com.socializaung.notifications;

import br.com.socializaung.core.user.User;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
@ToString
@Document
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Notification {

    @Id
    private String id;

    private String description;

    @DBRef
    private User notificatedBy;

    @DBRef
    private User toUser;
}
