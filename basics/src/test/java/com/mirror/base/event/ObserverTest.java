package com.mirror.base.event;

import com.mirror.base.BaseApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: mirror
 * @date: 2020/6/10 17:35
 * @description:
 */
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseApplication.class)
public class ObserverTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void Test01() {
        OrderEvent orderEvent = new OrderEvent(this, "用户下单成功");
        applicationContext.publishEvent(orderEvent);
        System.out.println("....................over........................");
    }

}
