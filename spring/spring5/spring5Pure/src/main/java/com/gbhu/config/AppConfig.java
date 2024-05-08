package com.gbhu.config;

import com.gbhu.domain.VideoOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    //不指定bean名称，默认 方法名（首字母小写）
    @Bean(name = "videoOrderName",initMethod = "init",destroyMethod = "destroy")
    @Scope("single")
    public VideoOrder getVideoOrder() {
        return new VideoOrder();
    }
}
