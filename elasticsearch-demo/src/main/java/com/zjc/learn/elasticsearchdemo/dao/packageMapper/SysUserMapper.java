package com.zjc.learn.elasticsearchdemo.dao.packageMapper;


import com.zjc.learn.elasticsearchdemo.model.packageModel.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author author
 */
public interface SysUserMapper extends JpaRepository<SysUser, Long> {

    List<SysUser> findAllByNickName(String name);
}