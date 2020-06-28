package com.mirror.transactionpropagation;

import com.mirror.transactionpropagation.service.BarService;
import com.mirror.transactionpropagation.service.FooService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@SpringBootApplication
@EnableTransactionManagement(mode = AdviceMode.PROXY)
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private BarService barService;
    @Autowired
    private FooService fooService;


    @Override
    public void run(String... args) throws Exception {
        //事务相关
        transaction();
    }

    private void transaction() {
        fooService.insertRecord();
        log.info("AAA {}", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='AAA'", Long.class));

        try {
            fooService.insertThenRollback();
        } catch (Exception e) {
            log.info("BBB {}", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'", Long.class));
        }

        try {
            fooService.invokeInsertThenRollback();
        } catch (Exception e) {
            log.info("BBB {}", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'", Long.class));
        }


    }
}
