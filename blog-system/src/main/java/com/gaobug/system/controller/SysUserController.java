package com.gaobug.system.controller;

import com.gaobug.system.service.SysUserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class SysUserController{

    @Resource
    private SysUserService userService;

//    @Override
//    @GetMapping(value = "getUserByName/{userName}")
//    public SysUser getUserByName(@PathVariable String userName) {
//        return userService.lambdaQuery().eq(SysUser::getUsername, userName).last("limit 1").one();
//    }

    @GetMapping(value = "getUserPermissions/{userId}")
    public Set<String> getUserPermissions(@PathVariable Integer userId) {
        return null;
    }
}