package cn.com.github.es;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;

public class KeywordSearch {
    public static void main(String[] args) throws IOException {
        //1.使用DirecrotyReader.open构建索引读取器
        DirectoryReader reader = DirectoryReader.open(FSDirectory.open(Paths.get("D:\\git\\SpringCloudDemo\\spring-netty-demo\\spring-es-servcie\\index")));
        //2.构建索引查询器
        IndexSearcher searcher = new IndexSearcher(reader);
        //3.构建词条和提条查询
//        new TermQuery("content","心");
    }
}
