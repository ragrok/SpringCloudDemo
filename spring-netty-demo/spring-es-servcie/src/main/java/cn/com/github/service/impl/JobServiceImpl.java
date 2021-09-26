package cn.com.github.service.impl;

import cn.com.github.entity.JobDetail;
import cn.com.github.mapper.JobRespository;
import cn.com.github.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.FuzzyQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRespository respository;
    @Autowired
    private ElasticsearchTemplate esTemplate;

    @Override
    public void add(JobDetail detail) throws IOException{
        JobDetail result =  respository.save(detail);
        if (result == null){
            throw new IOException("zhe li you wen ti");
        }
    }

    @Override
    public JobDetail findById(long id) throws IOException {
        return respository.findById(id).orElse(null);
    }

    @Override
    public void update(JobDetail jobDetail) throws IOException {
        JobDetail detail =  respository.save(jobDetail);
        if (detail == null){
            throw new IOException("zhe li you wen ti");
        }
    }

    @Override
    public void deleteById(long id) throws IOException {
        respository.deleteById(id);
    }

    @Override
    public List<JobDetail> searchByKeyWords(String keyWords) throws IOException {
        FuzzyQueryBuilder keywords = QueryBuilders.fuzzyQuery("keywords", keyWords);
        Iterable<JobDetail> search = respository.search(keywords);
        List<JobDetail> list = new ArrayList<>();
        search.forEach(list::add);
        return list;
    }

    @Override
    public Map<String, Object> searchPage(String keywords, int pageNum, int pageSize) throws IOException {
        Page<JobDetail> details = respository.search(QueryBuilders.matchQuery("keywords", keywords), PageRequest.of(pageNum,pageSize));
        return null;
    }

    @Override
    public Map<String, Object> searchByScrollPage(String keywords, String scrollId, int pageNum, int pageSize) throws IOException {
        return null;
    }

    @Override
    public void close() throws IOException{

    }
}
