package cn.com.github.consumer.impl.impl;

import cn.com.github.core.api.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Component
@Slf4j
public class TestServiceImpl implements TestService {


    public String addFeign(String param1) {
        log.info("comming in testFeign");
        return "test success";
    }
}
