package cn.com.github.producer.impl.impl;

import cn.com.github.producer.api.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;


@Component
@Slf4j
public class TestServiceImpl implements TestService {

    @Autowired(required = false)
    private RocketMQTemplate template;

    @Value("${rocketmq.producer.group}")
    private String group;

    @Value("${rocketmq.producer.topic}")
    private String topic;

    @Value("${rocketmq.producer.tag}")
    private String tag;

    public void sendSync() throws InterruptedException {
        for (int i=0; i < 1000; i++) {
            Message message = new Message(topic, tag, "hello world".getBytes());
            SendResult result = template.syncSend(topic,message);
            SendStatus status = result.getSendStatus();
            int queId = result.getMessageQueue().getQueueId();
            log.info("发送状态：{}，发送队列Id:{}",status,queId);

            TimeUnit.SECONDS.sleep(1);
        }
    }

    public void sendASync() {

    }

    public void sendOneWay() {

    }

    public void sendOrderMessage() {

    }

    public void sendBatchMessage() {

    }

    public void sendTransactionalMessage() throws InterruptedException {
        for (int i=0; i < 1000; i++) {
            Message message = new Message(topic, tag, ("hello world" + i).getBytes());
            template.setMessageQueueSelector(new MessageQueueSelector() {
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    long orderId = (Long) o;
                    long index = orderId % list.size();
                    return list.get((int) index);
                }
            });
            SendResult result = template.syncSend(topic,message);
            SendStatus status = result.getSendStatus();
            int queId = result.getMessageQueue().getQueueId();
            log.info("发送状态：{}，发送队列Id:{}",status,queId);

            TimeUnit.SECONDS.sleep(1);
        }
    }

    public void sendScheduledMessage() {

    }
}
