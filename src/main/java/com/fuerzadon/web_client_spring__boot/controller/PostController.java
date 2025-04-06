package com.fuerzadon.web_client_spring__boot.controller;
import com.fuerzadon.web_client_spring__boot.service.PostsService;
import com.fuerzadon.web_client_spring__boot.dto.PostsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostsService postsService;

    public PostController(PostsService postsService){
        this.postsService = postsService;
    }

    @PostMapping
    public ResponseEntity<Mono<PostsDto>> save(@RequestBody PostsDto postsDto){
        return new ResponseEntity<>(postsService.save(postsDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Flux<PostsDto>> getPosts(){
        return new ResponseEntity<>(postsService.getPosts(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Flux<PostsDto>> getPosts(@PathVariable Integer userId){
        return new ResponseEntity<>(postsService.getPostsByUser(userId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mono<PostsDto>> update(@PathVariable Integer id, @RequestBody PostsDto postsDto){
        return new ResponseEntity<>(postsService.update(id, postsDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        postsService.delete(id);
        return new ResponseEntity<>("Posts eliminado!", HttpStatus.OK);
    }




}


