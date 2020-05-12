package com.imooc.service;

import com.imooc.domain.Comment;
import com.imooc.domain.CommentSec;
import com.imooc.domain.Video;
import com.imooc.repository.CommentRepository;
import com.imooc.repository.CommentSecRepository;
import com.imooc.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentSecRepository commentSecRepository;
    //插入
    public void insertUrl(Video video){
        List<Video> videos = videoRepository.findVideosByUseridAndFilename(video.getUserid(),video.getFilename());
        if (videos.size()>0){
            videoRepository.delete(video);
        } videoRepository.save(video);
    }
    //查询
    public List<Video> findVideosByUserid(String userid){
        List<Video> shipins=videoRepository.findVideosByUserid(userid);
        return  shipins;
    }

    public List<Video> findAll() {
        List<Video> shipins=videoRepository.findAll();
        return  shipins;
    }
    public List<Video> findByType(Integer type) {
        List<Video> shipins=videoRepository.findVideosByType(type);
        return  shipins;
    }

    public Comment addComment(Comment comment) {
        Comment save = commentRepository.save(comment);
        return  save;
    }
    public CommentSec addComment(CommentSec comment) {
        CommentSec save = commentSecRepository.save(comment);
        return  save;
    }
}
