package br.com.socializaung.core.user;

import br.com.socializaung.post.Post;
import br.com.socializaung.relationship.Relationships;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.Instant;
import java.util.List;

@Getter
@Builder
@ToString
@Document
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private UserType type;

    @NotEmpty
    private String name;

    @Email
    private String email;

    @NotEmpty
    @JsonIgnore
    private String password;

    @LastModifiedDate
    private Instant lastLogin;

    @CreatedDate
    private Instant creationDate;

    @DBRef
    private List<Post> posts;


    private List<Relationships> relationships;


    public User encryptPassword(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        this.password = bCryptPasswordEncoder.encode(password);
        return this;
    }
}
