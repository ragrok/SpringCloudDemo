package cn.com.github.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @AUTHOR windli
 * @DATE 2021/8/3 11:26
 * @DESC
 **/
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("echo")
    public String echo(){
        return "echo";
    }
}
