package com.imooc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Video extends BaseEntity {

    @NotEmpty(message = "用户ID不能为空")
    private String userid;
//    @NotEmpty(message = "VideoID不能为空")
//    private String videoid;
    private String url;
    @NotEmpty(message = "视频标题不能为空")
    @Size(min = 3, max = 30, message = "视频标题长度应当在 3 ~ 40 个字符之间")
    private String videoTitle;
    private String videoCoverImgUrl;
    private String filename;
    private Integer type;
    private Integer playNum;
    private Integer zanNum;
    public String getVideoCoverImgUrl() {
        return videoCoverImgUrl;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPlayNum() {
        return playNum;
    }

    public Integer getZanNum() {
        return zanNum;
    }

    public void setZanNum(Integer zanNum) {
        this.zanNum = zanNum;
    }

    public void setPlayNum(Integer playNum) {
        this.playNum = playNum;
    }

    public void setVideoCoverImgUrl(String videoCoverImgUrl) {
        this.videoCoverImgUrl = videoCoverImgUrl;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
