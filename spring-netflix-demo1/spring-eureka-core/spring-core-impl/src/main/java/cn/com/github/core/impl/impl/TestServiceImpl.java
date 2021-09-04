package cn.com.github.core.impl.impl;

import cn.com.github.core.api.service.TestService;
import cn.com.github.user.api.service.UserService1;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Component
@Slf4j
public class TestServiceImpl implements TestService {

    @Autowired
    private UserService1 userService1;

    @HystrixCommand(fallbackMethod = "failMethod")
    public String addFeign(String param1) {
        log.info("comming in testFeign");
        userService1.testFeign("user");
        return "test success";
    }
}
