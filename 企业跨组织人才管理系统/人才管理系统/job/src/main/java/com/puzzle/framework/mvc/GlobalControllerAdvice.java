package com.puzzle.framework.mvc;

import com.puzzle.framework.exception.AuthException;
import com.puzzle.framework.exception.TokenException;
import com.puzzle.utils.Result;
import com.puzzle.utils.Status;
import jdk.nashorn.internal.parser.Token;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(TokenException.class)
    @ResponseBody
    public Result handle(TokenException exception){
        return Result.fail(Status.TOKEN_ERROR.getCode(),Status.TOKEN_ERROR.getMsg());
    }
    @ExceptionHandler(AuthException.class)
    @ResponseBody
    public Result handle(AuthException exception){
        return Result.fail(Status.NO_AUTH.getCode(),Status.NO_AUTH.getMsg());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result handle(RuntimeException exception){
        exception.printStackTrace();
        return Result.fail(exception.getMessage());
    }

}
