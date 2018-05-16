package com.zjc.learn.elasticsearchdemo;

import com.zjc.learn.elasticsearchdemo.dao.packageMapper.SysUserMapper;
import com.zjc.learn.elasticsearchdemo.dao.packageMapper.ela.BookRepository;
import com.zjc.learn.elasticsearchdemo.dao.packageMapper.ela.SysUserElaDao;
import com.zjc.learn.elasticsearchdemo.model.packageModel.Book;
import com.zjc.learn.elasticsearchdemo.model.packageModel.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.hibernate.cfg.annotations.QueryBinder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.SchemaOutputResolver;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ElasticsearchDemoApplicationTests {

    @Autowired
    private SysUserElaDao elaDao;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void contextLoads() {
        SysUser sysUser = new SysUser();
        sysUser.setNickName("lisi");
        sysUser.setAddress("lalalala");
        sysUser.setGroupId(154);
        sysUserMapper.save(sysUser);
        System.out.println(sysUser);

//        elaDao.save(sysUser);
        bookRepository.save(Book.builder().id(12 + "").author("张三").name("Think in Python").content("test").build());
    }

    @Test
    public void find() {
        bookRepository.deleteById("12");
//        Book book = bookRepository.findFirstByAuthor("张三");
        List<Book> books = bookRepository.findAllByAuthor("张三");
        List<Book> allByAuthorAndContentLike = bookRepository.findAllByAuthorAndContentLike("张三", "es");
        List<Book> es = bookRepository.findByNameLike("ja");
        Stream<Book> byNameLikeAndContent = bookRepository.findByNameLikeAndContent("ja", "test");
        List<Book> collect = byNameLikeAndContent.collect(Collectors.toList());
        log.info("es us []", es);

        System.out.println(allByAuthorAndContentLike);
        System.out.println(books);
    }

    @Test
    public void doQuerySearch() {
        BoolQueryBuilder must = QueryBuilders.boolQuery();
        must.must(QueryBuilders.fuzzyQuery("name", "java")).must(QueryBuilders.matchQuery("content","test"));
        Iterable<Book> rets = bookRepository.search(QueryBuilders.fuzzyQuery("content", "es"));
        rets = bookRepository.search(QueryBuilders.queryStringQuery("test"));
        rets = bookRepository.search(QueryBuilders.queryStringQuery("Think"));
        rets = bookRepository.search(QueryBuilders.termQuery("author", "张三"));
        rets = bookRepository.search(QueryBuilders.termQuery("author", "张"));
        rets = bookRepository.search(QueryBuilders.termQuery("author", "三"));
        rets = bookRepository.search(QueryBuilders.spanTermQuery("author", "张三"));
        rets = bookRepository.search(QueryBuilders.fuzzyQuery("name", "Java"));
        rets = bookRepository.search(QueryBuilders.fuzzyQuery("name", "in"));
        rets = bookRepository.search(must);
        rets.forEach(System.out::println);

    }

}
