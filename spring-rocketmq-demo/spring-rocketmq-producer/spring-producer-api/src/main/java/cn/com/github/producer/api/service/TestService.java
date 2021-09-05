package cn.com.github.producer.api.service;


public interface TestService {

    void sendSync() throws InterruptedException;

    void sendASync();

    void sendOneWay();

    void sendOrderMessage();

    void sendBatchMessage();

    void sendTransactionalMessage() throws InterruptedException;

    void sendScheduledMessage();
}
