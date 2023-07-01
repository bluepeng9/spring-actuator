package hello.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class TrafficController {

    @GetMapping("/cpu")
    public String cpu() {
        log.info("cpu");
        long value = 0;
        for (int i = 0; i < 100000000000L; i++) {
            value++;
        }
        return "ok value=" + value;
    }

    private List<String> list = new ArrayList<>();

    @GetMapping("/jvm")
    public String jvmc() {
        log.info("jvm");
        for (int i = 0; i < 100000; i++) {
            list.add("hello jvm!" + i);
        }
        return "ok";
    }
}
