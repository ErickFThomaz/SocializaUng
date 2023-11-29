package br.com.socializaung.core.user.web;

import br.com.socializaung.core.user.User;
import br.com.socializaung.core.user.UserCommand;
import br.com.socializaung.core.user.UserQuery;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/user")
public class UserRestService {

    private final UserQuery query;

    @GetMapping("/search/ongs")
    public EntityModel<List<User>> findOngs(@RequestParam("search") String ongName){
        return EntityModel.of(query.findByName(ongName));
    }
}
