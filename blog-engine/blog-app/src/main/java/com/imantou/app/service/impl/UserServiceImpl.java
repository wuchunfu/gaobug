package com.imantou.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imantou.app.dao.UserMapper;
import com.imantou.app.service.UserService;
import com.imantou.common.domain.User;
import org.springframework.stereotype.Service;

/**
 * @author huang
 * @description 针对表【t_user(用户表)】的数据库操作Service实现
 * @createDate 2022-05-30 14:00:27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}




