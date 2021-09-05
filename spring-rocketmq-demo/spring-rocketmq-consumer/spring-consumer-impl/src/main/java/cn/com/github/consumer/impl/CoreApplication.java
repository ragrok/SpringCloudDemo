package cn.com.github.consumer.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class CoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }


    @Slf4j
    @Service
    @RocketMQMessageListener(topic = "test-topic-1", consumerGroup = "test-group-1",
            selectorExpression = "i > 5", selectorType = SelectorType.SQL92)
    public static class MyConsumer1 implements RocketMQListener<Object> {
        public void onMessage(Object object) {
            log.info("received message: {}", JSON.toJSONString(object));
        }
    }
}
