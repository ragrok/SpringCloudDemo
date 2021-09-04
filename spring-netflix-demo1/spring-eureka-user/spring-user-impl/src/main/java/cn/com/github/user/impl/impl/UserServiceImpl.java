package cn.com.github.user.impl.impl;

import cn.com.github.user.api.service.UserService1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@RequestMapping("/user")
@Component
@Slf4j
public class UserServiceImpl implements UserService1 {

    public String testFeign(String param1) {
        log.info("comming in testFeign");
        return "test success";
    }
}
