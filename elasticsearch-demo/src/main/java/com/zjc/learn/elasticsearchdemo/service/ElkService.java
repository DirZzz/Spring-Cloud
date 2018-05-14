package com.zjc.learn.elasticsearchdemo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjc.learn.elasticsearchdemo.model.packageModel.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ElkService {
    @Autowired
    private TransportClient transportClient;


    private void index() throws JsonProcessingException {
        SysUser sysUser = new SysUser();
        byte[] bytes = new ObjectMapper().writeValueAsBytes(sysUser);
        IndexResponse indexResponse = transportClient.prepareIndex("test", "book")
                .setSource(bytes, XContentType.SMILE).get();
        log.info("status ---->"+indexResponse.status().getStatus());
    }
}
