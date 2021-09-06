package cn.com.github.consumer.impl.controller;

import cn.com.github.producer.api.service.DubboInterfaceTest;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class ConsumerController {

      @Reference(check = false, version = "0.0.1")
      private DubboInterfaceTest test;

      @GetMapping("/hello")
      public String sayHello(){
            return test.getTestSuccess();
      }
}
