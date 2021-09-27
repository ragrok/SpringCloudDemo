package cn.com.github.service;

import cn.com.github.entity.JobDetail;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface JobService {
    //添加职位数据接口
    void add(JobDetail detail) throws IOException;

    //根据指定ID检索指定职位数据
    JobDetail findById(long id) throws IOException;

    //修改薪资职位
    void update(JobDetail jobDetail) throws IOException;

    //根据ID删除指定位置数据
    void deleteById(long id) throws IOException;

    //根据关键字检索数据
    List<JobDetail> searchByKeyWords(String keyWords) throws IOException;

    //分页查询
    Map<String, Object> searchPage(String keywords, int pageNum, int pageSize) throws IOException;

    //scoll分页解决深分页问题
    Map<String, Object> searchByScrollPage(String keywords, String scrollId, int pageNum, int pageSize) throws IOException;

    //关闭接口
    void close() throws IOException;
}
