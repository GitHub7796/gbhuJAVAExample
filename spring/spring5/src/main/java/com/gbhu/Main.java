package com.gbhu;

import com.gbhu.aop.AnnotationAppConfig;
import com.gbhu.proxy.PayService;
import com.gbhu.proxy.PayServiceImpl;
import com.gbhu.proxy.StaticPayServiceProxy;
import com.gbhu.service.VideoService;
import com.gbhu.domain.Video;
import com.gbhu.domain.VideoOrder;
import com.gbhu.service.impl.VideoServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

//        ApplicationContext context = useXml();
//        test(context);
////       testInit(context);
//        //非web应用中关闭ioc容器，即显示调用destroy方法
//        ClassPathXmlApplicationContext context1 = (ClassPathXmlApplicationContext) context;
//        context1.registerShutdownHook();

//        AnnotationConfigApplicationContext context = useAnnotation();
//        VideoService videoService=context.getBean("video");
        //测试 xml aop
//        ApplicationContext context = useXml();
//        testAop(context);

        //测试 注解 aop
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AnnotationAppConfig.class);
        testAop(context);
    }

    public static AnnotationConfigApplicationContext useAnnotation() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //扫描指定的包，包括⼦子包
        context.scan("com.gbhu");
        //⾥里里⾯面完成初始化操作，核⼼心⽅方法
        context.refresh();
        return context;
    }

    public static ApplicationContext useXml() {
        System.out.println("指定bean配置文件");
        //指定bean配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        return context;
    }

    public static void test(ApplicationContext context) {
        System.out.println("从Spring中获取Bean");
        //从Spring中获取Bean
        Video video = (Video) context.getBean("video2");
        System.out.println(video.getTitle());
        VideoOrder videoOrder = (VideoOrder) context.getBean("videoOrder");
        System.out.println(videoOrder.getVideo().getTitle());

    }

    public static void testInit(ApplicationContext context) {
        Video video = (Video) context.getBean("video");
    }

    public static void testAop(ApplicationContext context) {
        VideoService videoService = (VideoService) context.getBean("videoService");//xml
        videoService.getById();
    }

}
