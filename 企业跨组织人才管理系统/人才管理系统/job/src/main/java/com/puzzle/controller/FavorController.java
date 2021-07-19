package com.puzzle.controller;

import com.github.pagehelper.PageInfo;
import com.puzzle.entity.Favor;
import com.puzzle.entity.Resume;
import com.puzzle.entity.Send;
import com.puzzle.service.*;
import com.puzzle.utils.Result;
import com.puzzle.vo.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/favor")
public class FavorController {

    @Autowired
    private FavorService favorService;
    @Autowired
    private UserDataService userDataService;
    @Autowired
    private ApplicantService applicantService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private PostService postService;


    @PostMapping("create")
    public Result create(@RequestBody Map<String,Integer> map){
        UserData userData = userDataService.getUserData();
        //1、判断用户是否登录
        if(userData == null){
            return Result.ok("未登录不能操作");
        }
        Integer postId = map.get("postId");
        Integer companyId = map.get("companyId");

        //2、判断是否重复收藏
        Favor favorParam = new Favor();
        favorParam.setApplicantId(userData.getId());
        favorParam.setPostId(postId);
        favorParam.setCompanyId(companyId);
        PageInfo<Favor> favorPageInfo = favorService.query(favorParam);
        if(favorPageInfo.getList() != null && favorPageInfo.getList().size()>0){
            return Result.fail("请勿重复收藏");
        }

        Favor favor = new Favor();
        favor.setPostId(postId);
        favor.setCompanyId(companyId);
        favor.setFavorDate(new Date());
        favor.setApplicantId(userData.getId());
        //3、收藏
        int row = favorService.create(favor);
        if(row>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = favorService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody Favor favor){
        int flag = favorService.update(favor);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public Result detail(Integer id){
        return  Result.ok(favorService.detail(id));
    }

    @PostMapping("query")
    public Map<String,Object> query(@RequestBody  Favor favor){
        PageInfo<Favor> pageInfo = favorService.query(favor);
        pageInfo.getList().forEach(item->{
            item.setCompany(companyService.detail(item.getCompanyId()));
            item.setApplicant(applicantService.detail(item.getApplicantId()));
            item.setPost(postService.detail(item.getPostId()));
        });
        return Result.ok(pageInfo);
    }

}
