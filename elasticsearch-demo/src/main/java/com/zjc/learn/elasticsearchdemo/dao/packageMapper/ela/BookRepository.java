package com.zjc.learn.elasticsearchdemo.dao.packageMapper.ela;

import com.zjc.learn.elasticsearchdemo.model.packageModel.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book,String> {

    Book findFirstByAuthor(String name);

    List<Book> findAllByAuthor(String name);

    List<Book> findAllByAuthorAndContentLike(String author, String span);

    List<Book> findByContentLike(String span);

}
