package cn.com.github;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDubbo(scanBasePackages = "cn.com.github.api")
@SpringBootApplication
@EnableDiscoveryClient
public class PayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class);
    }
}
