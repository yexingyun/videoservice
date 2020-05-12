package com.imooc.controller;

import com.imooc.domain.Result;
import com.imooc.domain.User;
import com.imooc.repository.UserRepository;
import com.imooc.service.GirlService;
import com.imooc.utils.IDUtils;
import com.imooc.utils.L;
import com.imooc.utils.ResultUtil;
import com.imooc.utils.TextUtils;
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
public class RegisterController {

    private final static Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private UserRepository girlRepository;

    @Autowired
    private GirlService girlService;

//    /**
//     * 查询所有女生列表
//     * @return
//     */
//    @GetMapping(value = "/girls")
//    public List<Girl> girlList() {
//        logger.info("girlList");
//
//        return girlRepository.findAll();
//    }

    public static boolean rexCheckPassword(String input) {
        // 8-20 位，字母、数字、字符
        String regStr = "^(?![a-zA-Z]+$)(?![A-Z0-9]+$)(?![A-Z\\W_]+$)(?![a-z0-9]+$)(?![a-z\\W_]+$)(?![0-9\\W_]+$)[a-zA-Z0-9\\W_]{8,20}$";
        return input.matches(regStr);
    }

    public static boolean rexCheckPhone(String input) {
        // 8-20 位，字母、数字、字符

        String PHONE_NUMBER_REG = "^(1[3-9])\\d{9}$";
        return input.matches(PHONE_NUMBER_REG);
    }

    @PostMapping("/user/register")
    public Result register(@Valid User user, BindingResult bindingResult) {
        System.out.println("username==" + user.getUsername());
        System.out.println("password==" + user.getPassword());
        if (bindingResult.hasErrors()) {
            String defaultMessage = bindingResult.getFieldError().getDefaultMessage();
            System.out.println("defaultMessage==" + defaultMessage);
            return ResultUtil.error(100, defaultMessage);
        }
        if (!rexCheckPassword(user.getPassword())) {
            return ResultUtil.error(101, "密码不符合要求,请输入八位且包含大写字母、小写字母和数字、特殊字符中的任意三种");
        }
        List<User> byUsername = girlRepository.findByUsername(user.getUsername());
        if (byUsername.size() > 0) {
            return ResultUtil.error(101, "用户名重复");
        }
        user.setUserid(IDUtils.createID());
        return ResultUtil.success(girlRepository.save(user), "注册成功");
    }

    @PostMapping("/user/login")
    public Result login(@RequestParam(required = true) String username, @RequestParam String password) {
        System.out.println("username==" + username);
        List<User> users;
        if (rexCheckPhone(username)) {
            users = girlRepository.findByPhoneAndPassword(username, password);
        } else {
            users = girlRepository.findByUsernameAndPassword(username, password);
        }
        System.out.println("password==" + password);
        return LoginHandle(users, false);
    }

    @GetMapping("/user/loginout/{username}")
    public Result loginout(@PathVariable("username") String username) {
        System.out.println("username==" + username);
        List<User> users;
        if (rexCheckPhone(username)) {
            users = girlRepository.findByPhone(username);
        } else {
            users = girlRepository.findByUsername(username);
        }
        return LoginHandle(users, true);
    }

    @PostMapping("/user/resetpassword")
    public Result resetpassword(@RequestParam("username") String username,@RequestParam("oldpsw") String oldpsw,@RequestParam("newpsw") String newpsw) {
        System.out.println("username==" + username);
        List<User> users;
        if (rexCheckPhone(username)) {
            users = girlRepository.findByPhone(username);
        } else {
            users = girlRepository.findByUsername(username);
        }
        return LoginHandle(users, true);
    }



    private Result LoginHandle(List<User> users, boolean isOut) {
        if (users != null && users.size() > 0) {
            User user = users.get(0);
            if (isOut) {
                user.setStatus(0);
                return ResultUtil.success(girlRepository.save(user), "退出成功");
            }
            user.setStatus(1);
            return ResultUtil.success(girlRepository.save(user), "登陆成功");
        } else {
            if (isOut) {
                return ResultUtil.success("退出失败，用户不存在");
            }
            return ResultUtil.error("登陆失败，用户名或密码错误");
        }
    }
}
