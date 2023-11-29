package br.com.socializaung.core.auth.login;

import br.com.socializaung.core.user.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SignupResource {

    private String name;

    @Enumerated(EnumType.STRING)
    private UserType type;

    private String email;

    private String password;

    private String confirmPassword;

    @JsonIgnore
    public boolean isPasswordNotEquals(){
        return !password.equals(confirmPassword);
    }
}
