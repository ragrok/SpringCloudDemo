package cn.com.github.controller;

import cn.com.github.api.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pay")
@Slf4j
public class PayController {

    @DubboReference(check = false, version = "1.0.0",retries = 3, timeout = 3000)
    private HelloService helloService;

    @PostMapping("getHello")
    public String getHello(@RequestHeader("hello") String hello, @RequestBody String value) {
        log.info("hello:{},value:{}", hello, value);
        return helloService.sayHello();
    }
}
