package com.imooc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Comment extends BaseEntity {
//    @Id
//    @GeneratedValue
    private String commentid;
//    @NotEmpty(message = "VideoID不能为空")
    private Integer videoid;

    private String formUserId;
    private String formUserImgUrl;


    private String content;
    private Integer numzan;

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }

    public Integer getVideoid() {
        return videoid;
    }

    public void setVideoid(Integer videoid) {
        this.videoid = videoid;
    }

    public String getFormUserId() {
        return formUserId;
    }

    public void setFormUserId(String formUserId) {
        this.formUserId = formUserId;
    }

    public String getFormUserImgUrl() {
        return formUserImgUrl;
    }

    public void setFormUserImgUrl(String formUserImgUrl) {
        this.formUserImgUrl = formUserImgUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNumzan() {
        return numzan;
    }

    public void setNumzan(Integer numzan) {
        this.numzan = numzan;
    }
}
