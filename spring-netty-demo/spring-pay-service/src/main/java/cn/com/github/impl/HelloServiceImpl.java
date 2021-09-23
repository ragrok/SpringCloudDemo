package cn.com.github.impl;

import cn.com.github.api.HelloService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0",retries = 3,timeout = 3000,mock = "return null")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello() {
        return "hello";
    }
}
