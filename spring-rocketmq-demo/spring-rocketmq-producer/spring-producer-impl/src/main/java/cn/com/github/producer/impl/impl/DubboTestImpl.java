package cn.com.github.producer.impl.impl;

import cn.com.github.producer.api.service.DubboInterfaceTest;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

@Slf4j
@Service(interfaceClass = DubboInterfaceTest.class, version = "0.0.1")
public class DubboTestImpl implements DubboInterfaceTest {

    public String getTestSuccess() {

        log.info("info success");
        return "success";
    }
}
