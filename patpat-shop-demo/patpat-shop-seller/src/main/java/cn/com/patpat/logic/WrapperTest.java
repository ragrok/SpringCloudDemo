package cn.com.patpat.logic;

import cn.com.patpat.entity.Test;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;

public class WrapperTest {

     @Autowired
    private QueryWrapper<Test> queryWrapper;


     public void test(){
         queryWrapper.select();
     }
}
