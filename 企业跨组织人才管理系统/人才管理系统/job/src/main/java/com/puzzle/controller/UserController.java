package com.puzzle.controller;

import com.github.pagehelper.PageInfo;
import com.puzzle.entity.User;
import com.puzzle.framework.role.RequiresRoles;
import com.puzzle.framework.role.Role;
import com.puzzle.service.UserService;
import com.puzzle.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("create")
    @RequiresRoles(type = Role.ADMIN)
    public Result create(@RequestBody User user){
        int flag = userService.create(user);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("delete")
    public Result delete(String ids){
        int flag = userService.delete(ids);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody User user){
        int flag = userService.update(user);
        if(flag>0){
            return Result.ok();
        }else{
            return Result.fail();
        }
    }

    @GetMapping("detail")
    public Result detail(Integer id){
        return  Result.ok(userService.detail(id));
    }

    @PostMapping("query")
    @RequiresRoles(type = Role.ADMIN)
    public Map<String,Object> query(@RequestBody  User user){
        PageInfo<User> pageInfo = userService.query(user);
        return Result.ok(pageInfo);
    }

}
