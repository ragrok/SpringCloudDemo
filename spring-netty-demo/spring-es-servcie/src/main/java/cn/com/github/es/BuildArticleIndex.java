package cn.com.github.es;

import cn.hutool.core.io.FileUtil;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class BuildArticleIndex {

    public static void main(String[] args) throws IOException {
        //构建分词器
        StandardAnalyzer analyzer = new StandardAnalyzer();
        //构建文档写入器配置
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        //构建文档写入器
        IndexWriter writer = new IndexWriter(FSDirectory.open(Paths.get("D:\\git\\SpringCloudDemo\\spring-netty-demo\\spring-es-servcie\\index")), indexWriterConfig);
        //读取所有文件夹
        File file = new File("D:\\git\\SpringCloudDemo\\spring-netty-demo\\spring-es-servcie\\data");
        File[] files = file.listFiles();
        //迭代所有的文件
        assert files != null;
        for (File file1 : files){
            Document document = new Document();
            document.add(new TextField("file_name",file1.getName(), Field.Store.YES));
            document.add(new TextField("conent", FileUtil.readString(file1,"utf-8"), Field.Store.NO));
            document.add(new TextField("path", file1.getPath(), Field.Store.NO));
            writer.addDocument(document);
        }
        writer.close();
    }
}
