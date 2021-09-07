package cn.com.github.user.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "spring-eureka-user", contextId = "UserService1")
public interface UserService1 {

    @PostMapping("/test")
    String testFeign(@RequestParam("param1") String param1);
}
