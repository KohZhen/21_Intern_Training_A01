package com.puzzle.service;

import com.puzzle.framework.exception.TokenException;
import com.puzzle.framework.redis.RedisUtil;
import com.puzzle.utils.Status;
import com.puzzle.utils.UserThreadLocal;
import com.puzzle.vo.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDataService {

    @Autowired
    private RedisUtil redisUtil;

    public UserData getUserData(){
        String token = UserThreadLocal.get();
        UserData userData = (UserData) redisUtil.get(token);
        if(userData != null){
            return userData;
        }else{
            throw new TokenException(Status.TOKEN_ERROR.getMsg());
        }
    }
}
