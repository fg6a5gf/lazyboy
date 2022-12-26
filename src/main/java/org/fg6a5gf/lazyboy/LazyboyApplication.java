package org.fg6a5gf.lazyboy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Map;

@RestController
@SpringBootApplication
public class LazyboyApplication {

    public static void main(String[] args) {
        SpringApplication.run(LazyboyApplication.class, args);
    }

    @GetMapping("/hello")
    Mono<Map<String, Object>> hello(@RequestParam(required = false, defaultValue = "100") Integer delay) {
        return Mono
                .delay(Duration.ofMillis(delay))
                .map(ms -> Map.of(
                        "hello", "Bob",
                        "delay", ms,
                        "timestamp", System.currentTimeMillis())
                );
    }
}
