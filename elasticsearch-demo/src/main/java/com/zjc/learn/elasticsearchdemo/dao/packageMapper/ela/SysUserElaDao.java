package com.zjc.learn.elasticsearchdemo.dao.packageMapper.ela;

import com.zjc.learn.elasticsearchdemo.model.packageModel.SysUser;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface SysUserElaDao extends ElasticsearchRepository<SysUser, String> {

    SysUser findTopByNickName(String name);

    List<SysUser> findAllByNickName(String name);

}
