package cn.com.github.order;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class OrderConsumer {

    public static void main(String[] args) throws Exception {
        String MQ_GROUP = "test-single-group";
        String MQ_TOPIC = "test-single-topic";
        String MQ_TAG = "test-single-tag";

        //准备工作
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(MQ_GROUP);
        consumer.setNamesrvAddr("192.168.47.142:9876;192.168.47.142:9877;192.168.47.142:9878");
        consumer.subscribe(MQ_TOPIC, "*");
        consumer.setMessageModel(MessageModel.BROADCASTING);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.registerMessageListener(new MessageListenerOrderly() {
            Random random = new Random();
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
                consumeOrderlyContext.setAutoCommit(true);
                for (MessageExt msg : list) {
                    // 可以看到每个queue有唯一的consume线程来消费, 订单对每个queue(分区)有序
                    System.out.println("consumeThread=" + Thread.currentThread().getName() + "queueId=" + msg.getQueueId() + ", content:" + new String(msg.getBody()));
                }

                try {
                    //模拟业务逻辑处理中...
                    TimeUnit.SECONDS.sleep(random.nextInt(10));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });

        consumer.start();

        System.out.println("Consumer Started.");
    }
}
