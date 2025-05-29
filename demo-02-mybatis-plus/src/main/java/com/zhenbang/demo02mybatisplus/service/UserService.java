package com.zhenbang.demo02mybatisplus.service;

import com.zhenbang.demo02mybatisplus.domain.po.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administer
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2025-05-28 14:34:56
*/
public interface UserService extends IService<User> {

    void deductBalance(Long id, Integer money);

    List<User> queryUsers(String name, Integer status, Integer minBalance, Integer maxBalance);
}
