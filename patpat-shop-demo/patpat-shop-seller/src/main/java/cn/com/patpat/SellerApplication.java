package cn.com.patpat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableTransactionManagement
@SpringBootApplication
@MapperScan(basePackages = "cn.com.patpat.mapper")
public class SellerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellerApplication.class);
    }
}
