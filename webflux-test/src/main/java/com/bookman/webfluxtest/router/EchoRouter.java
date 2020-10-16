package com.bookman.webfluxtest.router;

import com.bookman.webfluxtest.handler.EchoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class EchoRouter {
    @Bean
    public RouterFunction<ServerResponse> route(EchoHandler echoHandler){
        return RouterFunctions.route(RequestPredicates.POST("/echo"), echoHandler::handle);
    }

}
