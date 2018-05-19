package com.sky.demo.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sky.common.entity.Result;
import com.sky.common.enums.ResultEnum;
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
        String str = "hello 垃圾";

        return Mono.create(testMonoSink -> testMonoSink.success(str));
    }

    @GetMapping("/add")
    public Mono<Result> add() {
        User user = new User();
        user.setName("name 垃圾");
        user.setTitle("title 这是简介");
        userService.addUser(user);
        user.setName("name 垃圾2");
        user.setTitle("title 健康的就是看到");
        userService.addUser(user);
        user.setName("name 垃圾3");
        user.setTitle("title 税控我诶嘿");
        userService.addUser(user);
        user.setName("name 垃4");
        user.setTitle("title 五十五一UI的");
        userService.addUser(user);


        return Mono.create(testMonoSink -> testMonoSink.success(new Result(ResultEnum.SUCCESS)));
    }
}
