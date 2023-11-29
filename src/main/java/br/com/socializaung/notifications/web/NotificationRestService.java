package br.com.socializaung.notifications.web;

import br.com.socializaung.notifications.Notification;
import br.com.socializaung.notifications.NotificationQuery;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/notifications")
public class NotificationRestService {

    private final NotificationQuery query;

    @GetMapping
    public EntityModel<List<Notification>> findAll(){
        return EntityModel.of(query.findAll());
    }
}
