package com.sky.demo.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sky.demo.entity.User;
import com.sky.demo.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class UserApi {

    @Reference(version = "1.0.0")
    private IUserService userService;


    @GetMapping("/test")
    public Flux<User> getUsers() {
        return Flux.create(userFluxSink -> {
            userService.getUserList().forEach(user -> {
                userFluxSink.next(user);
            });
            userFluxSink.complete();
        });
    }

    @GetMapping("/abc")
    public Mono<String> test2() {
        String str = "hello world";

        return Mono.create(testMonoSink -> testMonoSink.success(str));
    }
}
