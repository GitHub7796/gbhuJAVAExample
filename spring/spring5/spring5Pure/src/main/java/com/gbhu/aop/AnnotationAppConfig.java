package com.gbhu.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("com.gbhu")
@EnableAspectJAutoProxy//开启aop
public class AnnotationAppConfig {

}
