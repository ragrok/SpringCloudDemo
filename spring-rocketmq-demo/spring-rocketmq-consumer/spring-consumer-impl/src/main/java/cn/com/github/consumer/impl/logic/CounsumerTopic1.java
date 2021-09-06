package cn.com.github.consumer.impl.logic;


import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RocketMQMessageListener(topic = "${rocketmq.consumer.topic}", consumerGroup = "${rocketmq.consumer.group}", selectorType = SelectorType.TAG)
public class CounsumerTopic1 implements RocketMQListener<String> {

    public void onMessage(String s) {
        log.info("接受到的信息：{}",s);
    }
}
