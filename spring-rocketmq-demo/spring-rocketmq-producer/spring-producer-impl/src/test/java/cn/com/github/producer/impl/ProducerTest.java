package cn.com.github.producer.impl;

import cn.com.github.producer.impl.base.Base;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProducerTest extends Base {

    @Autowired
    private RocketMQTemplate template;

    @Value("${rocketmq.producer.topic}")
    private String topic;

    @Value("${rocketmq.producer.tag}")
    private String tag;

    @Test
    public void test1() {
        template.convertAndSend(topic, "hello");
    }
}
