package com.sky.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

@Document(indexName = "tb_demo", type = "demo" )
public class UserSearch implements Serializable  {

    @Id
    private long    id;
    @Field(searchAnalyzer = "ik_smart", analyzer = "ik_smart")
    private String  name;
    @Field(searchAnalyzer = "ik_smart", analyzer = "ik_smart")
    private String  title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
