package com.imooc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class CommentSec extends BaseEntity {

    @NotEmpty(message = "评论id不能为空")
    private String commentid;//评论id
    private String commenterid;//评论者用户id

    private String replyer_id;//回复评论的用户的id
    private String commenterImgUrl;
    private String replyerImgUrl;//回复评论的用户头像


    private String content;
    private Integer numzan;



    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }

    public String getCommenterid() {
        return commenterid;
    }

    public void setCommenterid(String commenterid) {
        this.commenterid = commenterid;
    }

    public String getReplyer_id() {
        return replyer_id;
    }

    public void setReplyer_id(String replyer_id) {
        this.replyer_id = replyer_id;
    }

    public String getCommenterImgUrl() {
        return commenterImgUrl;
    }

    public void setCommenterImgUrl(String commenterImgUrl) {
        this.commenterImgUrl = commenterImgUrl;
    }

    public String getReplyerImgUrl() {
        return replyerImgUrl;
    }

    public void setReplyerImgUrl(String replyerImgUrl) {
        this.replyerImgUrl = replyerImgUrl;
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
