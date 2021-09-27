package cn.com.github.entity;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Getter
@Setter
@Document(indexName = "job",shards = 1,replicas = 1)
public class JobDetail implements Serializable {

    @Id
    private String id;
    @Field(type = FieldType.Keyword)
    private String area;
    @Field(type = FieldType.Integer)
    private String exp;
    @Field(type = FieldType.Long)
    private String edu;
    @Field(type = FieldType.Text)
    private String salary;
    @Field(type = FieldType.Keyword)
    private String job_type;
    @Field(type = FieldType.Keyword, analyzer = "ik_smart", searchAnalyzer = "ik_max_word")
    private String cmp;
    @Field(type = FieldType.Keyword)
    private String pv;
    @Field(type = FieldType.Keyword)
    private String title;
    @Field(type = FieldType.Text, analyzer = "ik_smart", searchAnalyzer = "ik_max_word")
    private String jd;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
