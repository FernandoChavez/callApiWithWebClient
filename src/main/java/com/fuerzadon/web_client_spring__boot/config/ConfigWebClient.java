package com.fuerzadon.web_client_spring__boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ConfigWebClient {

    String url = "https://jsonplaceholder.typicode.com";

    @Bean
    WebClient webClient(){
        return WebClient.builder().baseUrl(url).build();
    }

}
