package cn.com.patpat.service.impl;

import cn.com.patpat.mapper.DemoMapper;
import cn.com.patpat.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

     @Autowired
    private DemoMapper demoMapper;

     public void test1(){
         demoMapper.
     }
}
