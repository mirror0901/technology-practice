package com.mirror.transactionpropagation;

import com.mirror.transactionpropagation.common.Global;
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

import javax.xml.bind.annotation.XmlElementDecl;

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
//        fooService.insertRecord();
//        log.info("AAA {}", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='AAA'", Long.class));

        //抛出异常sql回滚了
//        try {
//            fooService.insertThenRollback();
//        } catch (Exception e) {
//            log.info("BBB {}", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'", Long.class));
//        }

        //抛出异常但是还是执行了sql
//        try {
//            fooService.invokeInsertThenRollback();
//        } catch (Exception e) {
//            log.info("BBB {}", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO WHERE BAR='BBB'", Long.class));
//        }

        String noException = Global.REQUIRES_NEW_NO_EXCEPTION;
        String hasException = Global.REQUIRES_NEW_HAS_EXCEPTION;

        try {
            barService.noTransactional();
        } catch (Exception e) {
            if (Global.MANDATORY_HAS_EXCEPTION.equals(hasException)) {
                log.error(e.toString());
            }
            log.info("第一种情况 {}", jdbcTemplate.queryForObject(
                    "SELECT COUNT(*) FROM FOO WHERE BAR = '" + hasException + "'",
                    Long.class
            ));
        }

        try {
            barService.hasTransactional();
        } catch (Exception e) {
            log.info("第二种情况 {}", jdbcTemplate.queryForObject(
                    "SELECT COUNT(*) FROM FOO WHERE BAR='" + noException + "'",
                    Long.class));
        }

        // 内嵌异常，内异常回滚不影响外层异常
//        try {
//            barService.hasTransactionalNoException();
//        } catch (Exception e) {
//            log.info("第三种情况 {}", jdbcTemplate.queryForObject(
//                    "SELECT COUNT(*) FROM FOO WHERE BAR='" + Global.NESTED_HAS_EXCEPTION_TWO + "'",
//                    Long.class));
//        }

    }
}
