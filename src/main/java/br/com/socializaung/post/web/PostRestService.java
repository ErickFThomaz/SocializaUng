package br.com.socializaung.post.web;

import br.com.socializaung.core.user.User;
import br.com.socializaung.post.Post;
import br.com.socializaung.post.PostCommand;
import br.com.socializaung.post.PostQuery;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/post")
public class PostRestService {

    private final PostQuery query;

    private final PostCommand command;


    @PostMapping
    public ResponseEntity<Post> create(@Valid @RequestBody Post post){
        return ResponseEntity.status(CREATED).body(command.create(post));
    }

    @GetMapping
    public ResponseEntity<List<Post>> findAllPosts(){
        return ResponseEntity.ok(query.findAllPosts());
    }

    @GetMapping("/my")
    public ResponseEntity<List<Post>> findMyAllPosts(){
        return ResponseEntity.ok(query.findMyAllPosts());
    }
}
