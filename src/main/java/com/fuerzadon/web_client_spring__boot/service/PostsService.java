package com.fuerzadon.web_client_spring__boot.service;

import com.fuerzadon.web_client_spring__boot.dto.PostsDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PostsService {

    private final WebClient webClient;

    public PostsService(WebClient webClient){
        this.webClient = webClient;
    }

    //crear metodo para guardar un post deto
    public Mono<PostsDto> save(PostsDto postsDto){
        return webClient
                .post()
                .uri("/posts")
                .bodyValue(postsDto)
                .retrieve()
                .bodyToMono(PostsDto.class);
    }

    // Con Flux podemos decir que podemos tener carios elementos
    public Flux<PostsDto> getPosts(){
        return webClient.get()
                .uri("/posts")
                .retrieve()
                .bodyToFlux(PostsDto.class);

    }

    public Flux<PostsDto> getPostsByUser(Integer userId){
        return webClient.get()
                .uri("/users/"+userId+"/posts")
                .retrieve()
                .bodyToFlux(PostsDto.class);
    }

    //aqui actualizamos un post

    public Mono<PostsDto> update(Integer id, PostsDto postDto){
        return webClient
                .put()
                .uri("/posts/"+id)
                .bodyValue(postDto)
                .retrieve()
                .bodyToMono(PostsDto.class);
    }

    //eliminar post

    public void delete(Integer id){
    webClient
            .delete()
            .uri("/posts"+id)
            .retrieve()
            .bodyToMono(PostsDto.class);

    }


}
