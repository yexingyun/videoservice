package com.imooc.repository;

import com.imooc.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * Created by 廖师兄
 * 2016-11-03 23:17
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(nativeQuery = true,value = "select * FROM user where username=?")
    List<User> findByUsername(String username);

    List<User> findByPhone(String phone);
    List<User> findByPhoneAndPassword(String Phone,String Password);
    List<User> findByUsernameAndPassword(String Username,String Password);
}
