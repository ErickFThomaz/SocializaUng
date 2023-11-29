package br.com.socializaung.core.auth.login.web;

import br.com.socializaung.core.user.User;
import br.com.socializaung.core.user.UserQuery;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/teste")
public class TesteRest {

    private final UserQuery query;

    @GetMapping
    public ResponseEntity<List<User>> teste(Pageable pageable){
        return ResponseEntity.ok(query.findAll());
    }
}
