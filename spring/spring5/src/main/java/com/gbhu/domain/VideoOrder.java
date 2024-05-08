package com.gbhu.domain;

public class VideoOrder {

    public VideoOrder(Video video) {
        this.video = video;
    }

    public void init() {
        System.out.println("VideoOrder-init");

    }
    public VideoOrder() {
        System.out.println("VideoOrder-无参构造函数");
    }

    private Integer id;
    private Integer outTradeNo;

    private Video video;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        System.out.println("VideoOrder-set-id");
        this.id = id;
    }

    public Integer getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(Integer outTradeNo) {
        System.out.println("VideoOrder-set-outTradeNo");
        this.outTradeNo = outTradeNo;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        System.out.println("VideoOrder-set-video");
        this.video = video;
    }

    private void destroy() {
        System.out.println("VideoOrder-destroy");
    }
}
