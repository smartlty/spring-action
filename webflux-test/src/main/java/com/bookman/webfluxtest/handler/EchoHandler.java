package com.bookman.webfluxtest.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class EchoHandler {
    public Mono<ServerResponse> handle(ServerRequest request) {
        request.headers().asHttpHeaders().forEach((key, value) -> {
            System.out.println("header = " + key  + " : " + value);
        });

        return request.bodyToMono(String.class).flatMap(data -> ServerResponse.ok().body(Mono.just(data), String.class));
    }
}
