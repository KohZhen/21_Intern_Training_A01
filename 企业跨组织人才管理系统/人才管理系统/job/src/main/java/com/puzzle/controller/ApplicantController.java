package com.puzzle.controller;

import com.github.pagehelper.PageInfo;
import com.puzzle.entity.Applicant;
import com.puzzle.framework.redis.RedisUtil;
import com.puzzle.framework.role.RequiresRoles;
import com.puzzle.framework.role.Role;
import com.puzzle.service.ApplicantService;
import com.puzzle.utils.Result;
import com.puzzle.utils.UserThreadLocal;
import com.puzzle.vo.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("create")
    public Result create(@RequestBody Applicant applicant){
        int flag = applicantService.create(applicant);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = applicantService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody Applicant applicant){
        int flag = applicantService.update(applicant);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public Result detail(Integer id){
        return  Result.ok(applicantService.detail(id));
    }

    @GetMapping("info")
    @RequiresRoles(type = Role.APPLICANT)
    public Result info(){
        String token = UserThreadLocal.get();
        UserData userData = (UserData) redisUtil.get(token);
        return  Result.ok(applicantService.detail(userData.getId()));
    }

    @PostMapping("query")
    public Map<String,Object> query(@RequestBody  Applicant applicant){
        PageInfo<Applicant> pageInfo = applicantService.query(applicant);
        return Result.ok(pageInfo);
    }



}
