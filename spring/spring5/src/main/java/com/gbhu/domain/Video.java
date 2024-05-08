package com.gbhu.domain;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

//遵循JavaBean规范
@Component

public class Video {
    private Integer id;
    private String title;

    public void init() {
        System.out.println("Video-init");
    }
    public void destroy() {
        System.out.println("Video-destroy");
    }
//
//    private List<String> chapterList;
//
//    private Map<Integer, String> videoMap;
//
//    public List<String> getChapterList() {
//        return chapterList;
//    }
//
//    public void setChapterList(List<String> chapterList) {
//        this.chapterList = chapterList;
//    }
//
//    public Map<Integer, String> getVideoMap() {
//        return videoMap;
//    }
//
//    public void setVideoMap(Map<Integer, String> videoMap) {
//        this.videoMap = videoMap;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        System.out.println("video-set-id");
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        System.out.println("video-set-title");
        this.title = title;
    }

    public Video() {
        System.out.println("video-无参构造函数");
    }

    public Video(String title) {
        System.out.println("video-有参构造函数");
        this.title = title;
    }
}
