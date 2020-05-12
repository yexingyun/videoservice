package com.imooc.repository;

import com.imooc.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Created by 廖师兄
 * 2016-11-03 23:17
 */
public interface VideoRepository extends JpaRepository<Video, Integer> {
 public List<Video> findVideosByUseridAndFilename(String userid, String fileName);
 public List<Video> findVideosByUserid(String userid);
 public List<Video> findVideosByType(Integer type);
}
