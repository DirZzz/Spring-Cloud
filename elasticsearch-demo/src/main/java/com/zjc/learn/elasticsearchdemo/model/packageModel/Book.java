package com.zjc.learn.elasticsearchdemo.model.packageModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "book_index",type = "book")
public class Book implements Serializable {
    @Id
    private String id;
    private String name;
    private String author;
    private String content;
}
