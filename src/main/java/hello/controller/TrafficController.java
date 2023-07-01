package hello.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
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

    @Autowired
    DataSource dataSource;

    @GetMapping("/jvm")
    public String jvmc() {
        log.info("jvm");
        for (int i = 0; i < 100000; i++) {
            list.add("hello jvm!" + i);
        }
        return "ok";
    }

    @GetMapping("/jdbc")
    public String jdbc() throws SQLException {
        log.info("jdbc");
        Connection conn = dataSource.getConnection();
        log.info("Connection info={}", conn);
        //conn.close(); 커넥션을 닫지 않는다.
        return "ok";
    }
}
