package com.jtsp.springboot3elk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class SpringBoot3ElkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot3ElkApplication.class, args);
    }


    @GetMapping("ok/{count}")
    public String ok(@PathVariable Integer count) {
        for (int i = 0; i < count; i++) {
            log.info("ok response: {}", i);
        }
        return "completed";
    }

    @GetMapping("error/{count}")
    public String error(@PathVariable Integer count) {
        for (int i = 0; i < count; i++) {
            log.error("error response: {}", i);
        }
        throw new RuntimeException("error");
    }

    @GetMapping("debug/{count}")
    public String debug(@PathVariable Integer count) {
        for (int i = 0; i < count; i++) {
            log.debug("ok response: {}", i);
        }
        return "debug process completed";
    }

    @GetMapping("badRequest/{count}")
    public ResponseEntity<String> badRequest(@PathVariable Integer count) {
        for (int i = 0; i < count; i++) {
            log.info("bad response: {}", i);
        }
        return ResponseEntity.badRequest().body("bad request");
    }

    @GetMapping("unauthorize/{count}")
    public ResponseEntity<String> unauthorize(@PathVariable Integer count) {
        for (int i = 0; i < count; i++) {
            log.error("unauthorize response: {}", i);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("not authorize");
    }

}
