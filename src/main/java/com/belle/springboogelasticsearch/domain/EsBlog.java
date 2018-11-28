package com.belle.springboogelasticsearch.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @ClassName EsBlog
 * @Description Es 文档类
 * @Author sunp
 * @Date 2018/11/28 14:17
 * @Version 0.0.1
 **/
@Document(indexName = "blog",type = "blog") //标识 文档
public class EsBlog  implements Serializable {
    @Id //标识主键
    private  String id;
    //标题
    private  String title;
    //摘要
    private  String summary;
    //正文内容
    private  String content;

    protected  EsBlog(){ //JPA 规范要求，防止直接使用

    }

    public  EsBlog( String title,String summary, String content){
        this.title = title;
        this.summary = summary;
        this.content = content;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "EsBlog{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
