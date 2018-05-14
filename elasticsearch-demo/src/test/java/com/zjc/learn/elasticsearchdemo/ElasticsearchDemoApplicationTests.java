package com.zjc.learn.elasticsearchdemo;

import com.zjc.learn.elasticsearchdemo.dao.packageMapper.SysUserMapper;
import com.zjc.learn.elasticsearchdemo.dao.packageMapper.ela.BookRepository;
import com.zjc.learn.elasticsearchdemo.dao.packageMapper.ela.SysUserElaDao;
import com.zjc.learn.elasticsearchdemo.model.packageModel.Book;
import com.zjc.learn.elasticsearchdemo.model.packageModel.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
        bookRepository.save(Book.builder().id(12+"").author("张三").name("Think in Java").content("test").build());
    }

    @Test
    public void  find(){
        bookRepository.deleteById("12");
//        Book book = bookRepository.findFirstByAuthor("张三");
        List<Book> books = bookRepository.findAllByAuthor("张三");
        List<Book> allByAuthorAndContentLike = bookRepository.findAllByAuthorAndContentLike("张三", "es");
        List<Book> es = bookRepository.findByContentLike("es");
        log.info("es us []",es);
        System.out.println(allByAuthorAndContentLike);
        System.out.println(books);
    }

}
