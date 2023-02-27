package cn.com.github.es;

import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Slf4j
public class KeywordSearch {
    public static void main(String[] args) throws IOException {
        //1.使用DirecrotyReader.open构建索引读取器
        DirectoryReader reader = DirectoryReader.open(FSDirectory.open(new File("D:\\git\\SpringCloudDemo\\spring-netty-demo\\spring-es-servcie\\index")));
        //2.构建索引查询器
        IndexSearcher searcher = new IndexSearcher(reader);
        //3.构建词条和提条查询
        TermQuery query = new TermQuery(new Term("content", "我"));
        //执行查询，获取文档
        TopDocs topDocs = searcher.search(query,50);
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            //获取document
            Document doc = searcher.doc(scoreDoc.doc);
            log.info("=================");
            log.info("文件名：{}",doc.get("file_name"));
            log.info("文件名：{}",doc.get("path"));
            log.info("文件名：{}",doc.get("content"));
        }
       reader.close();
    }
}
