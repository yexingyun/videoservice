package com.imooc.controller;

import com.imooc.domain.*;
import com.imooc.repository.UserRepository;
import com.imooc.service.GirlService;
import com.imooc.service.VideoService;
import com.imooc.utils.IDUtils;
import com.imooc.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by 廖师兄
 * 2016-11-03 23:15
 */
@RestController
public class VideoListController {

    private final static Logger logger = LoggerFactory.getLogger(VideoListController.class);

    @Autowired
    private VideoService videoService;


    /**
     * 查询所有视频列表
     *
     * @return
     */
    @GetMapping(value = "/videos")
    public Result videosList(@RequestParam("type" )Integer type) {
        if (type==0){
            logger.info("girlList");
            return ResultUtil.success(videoService.findAll());
        }else {
            return ResultUtil.success( videoService.findByType(type));
        }

    }

    /**
     * 查询所有用户视频列表
     *
     * @return
     */
    @GetMapping(value = "/userVideosList/{userid}")
    public List<Video> userVideosList(@PathVariable("userid") String userid) {
        logger.info("userVideosList");
        return videoService.findVideosByUserid(userid);
    }

    /**
     * 视频评论添加
     *
     * @return
     */
    @PostMapping(value = "/addVideosComment")
    public Result videosCommentAdd(@Valid Comment comment, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        comment.setCommentid(IDUtils.createLongID());
        return ResultUtil.success(videoService.addComment(comment));
    }
 @PostMapping(value = "/addVideosCommentSec")
    public Result videosCommentSecAdd(@Valid CommentSec commentSec, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(videoService.addComment(commentSec));
    }

}
