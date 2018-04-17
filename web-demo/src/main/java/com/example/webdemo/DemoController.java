package com.example.webdemo;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuples;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Ralf Chen on 2018/4/10 0010.
 */
@RequestMapping("/")
@Controller
public class DemoController {

    @RequestMapping
    @ResponseBody
    public String Hello() {
        return "hello world";
    }

//    @GetMapping("index")
//    public String index(){
//        return "index2";
//    }

    /**
     * 响应式web方法
     *
     * @return
     */
    @GetMapping("/hello_world")
    public Mono<String> sayHelloWorld() {
        return Mono.just("Hello World");
    }

    @RestController
    @RequestMapping("/sse")
    public class SseController {
        @GetMapping("/randomNumbers")
        public Flux<ServerSentEvent<Integer>> randomNumbers() {
            return Flux.interval(Duration.ofSeconds(1))
                    .map(seq -> Tuples.of(seq, ThreadLocalRandom.current().nextInt()))
                    .map(data -> ServerSentEvent.<Integer>builder()
                            .event("random")
                            .id(Long.toString(data.getT1()))
                            .data(data.getT2())
                            .build());
        }
    }
}
