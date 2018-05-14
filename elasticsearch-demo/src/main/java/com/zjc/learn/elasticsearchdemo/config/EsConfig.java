package com.zjc.learn.elasticsearchdemo.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

//@Configuration
//@EnableElasticsearchRepositories("com.zjc.learn.elasticsearchdemo.dao.packageMapper.ela")
public class EsConfig {
    @Value("${elasticsearch.host}")
    private String EsHost;
    @Value("${elasticsearch.clusterName}")
    private String EsClusterName;
    @Value("${elasticsearch.port}")
    private String EsPort;


    @Bean
    public Client client() throws Exception {

        Settings esSettings = Settings.builder()
                .put("cluster.name", EsClusterName)
                .build();
        return new PreBuiltTransportClient(esSettings);
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }
}
