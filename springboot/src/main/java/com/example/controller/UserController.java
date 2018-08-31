package com.example.controller;


import com.example.threadlocal.RequestHolder;
import com.example.pojo.Users;
import com.example.service.IUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUsers userService;

    @RequestMapping(value = {"/findAll"},produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    public Users getAllUsers(){
        Users user =  userService.findAll();
        return user;
    }

    @RequestMapping(value ="test" )
    @ResponseBody
    public Long test(){
        return RequestHolder.getId();
    }

}
