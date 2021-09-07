package cn.com.github.core.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "spring-eureka-core", contextId = "TestService")
//@RequestMapping("/core")
public interface TestService {

    @PostMapping("/add")
    String addFeign(@RequestParam("param1") String param1);
}
