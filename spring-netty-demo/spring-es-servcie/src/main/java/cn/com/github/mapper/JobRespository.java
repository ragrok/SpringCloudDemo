package cn.com.github.mapper;

import cn.com.github.entity.JobDetail;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRespository extends ElasticsearchRepository<JobDetail,Long> {

    List<JobDetail> findByUsername(String name);
}
