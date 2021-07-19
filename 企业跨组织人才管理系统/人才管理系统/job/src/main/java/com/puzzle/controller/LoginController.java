package com.puzzle.controller;

import com.puzzle.entity.Company;
import com.puzzle.entity.Applicant;
import com.puzzle.entity.User;
import com.puzzle.framework.redis.RedisUtil;
import com.puzzle.framework.role.Role;
import com.puzzle.service.CompanyService;
import com.puzzle.service.ApplicantService;
import com.puzzle.service.UserService;
import com.puzzle.utils.Result;
import com.puzzle.vo.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ApplicantService applicantService;

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/login")
    public Result login(@RequestBody Map<String,String> map){

        String account = map.get("account");
        String password = map.get("password");
        String type = map.get("type");

        boolean flag = false;
        UserData userData = new UserData();
        if(String.valueOf(Role.ADMIN.getCode()).equals(type)){ //管理员登录
            User login = userService.login(account, password);
            if(login != null){
                userData.setId(login.getId());
                userData.setAccount(login.getUserName());
                userData.setName(login.getName());
                userData.setType(Role.ADMIN.getCode());
                flag = true;
            }
        }

        if(String.valueOf(Role.COMPANY.getCode()).equals(type)){ //企业登录
            Company login = companyService.login(account, password);
            if(login != null){
                userData.setId(login.getId());
                userData.setAccount(login.getAccount());
                userData.setName(login.getName());
                userData.setType(Role.COMPANY.getCode());
                flag = true;
            }
        }

        if(String.valueOf(Role.APPLICANT.getCode()).equals(type)){ //员工登录
            Applicant login = applicantService.login(account, password);
            if(login != null){
                userData.setId(login.getId());
                userData.setAccount(login.getAccount());
                userData.setName(login.getName());
                userData.setType(Role.APPLICANT.getCode());
                flag = true;
            }
        }
        if(flag){
            //登录成功的情况
            String token = UUID.randomUUID().toString();
            userData.setToken(token);
            redisUtil.set(token,userData,RedisUtil.EXPR);
            return Result.ok(userData);
        }else{
            return Result.fail("用户或密码错误");
        }
    }

}
