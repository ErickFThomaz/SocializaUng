package br.com.socializaung.post;

import br.com.socializaung.core.user.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.HashMap;

@Getter
@Builder
@ToString
@Document
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Post {

    @Id
    private String id;

    @Builder.Default
    private Instant createdAt = Instant.now();

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private PostType type = PostType.TEXT;

    @Size(max = 400)
    private String content;

    private HashMap<String, String> data;

    @DBRef
    private User user;

    public Post withUser(User user){
        this.user = user;
        return this;
    }
}
