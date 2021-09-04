package cn.com.github.user.impl.impl;

import cn.com.github.user.api.service.UserService1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Component
@Slf4j
public class UserServiceImpl implements UserService1 {

    public String testFeign(String param1) {
        log.info("comming in testFeign");
        return "test success";
    }
}
