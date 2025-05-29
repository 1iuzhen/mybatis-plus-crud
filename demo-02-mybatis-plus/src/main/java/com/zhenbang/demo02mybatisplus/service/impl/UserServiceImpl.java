package com.zhenbang.demo02mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhenbang.demo02mybatisplus.domain.po.User;
import com.zhenbang.demo02mybatisplus.enums.UserStatus;
import com.zhenbang.demo02mybatisplus.service.UserService;
import com.zhenbang.demo02mybatisplus.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administer
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2025-05-28 14:34:56
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
    @Override
    public void deductBalance(Long id, Integer money) {
        // 1.查询用户
        User user = getById(id);
        // 2.校验用户状态
        if (user == null || user.getStatus() == 2) {
            throw new RuntimeException("用户状态异常！");
        }
        // 3.校验余额是否充足
        if (user.getBalance() < money) {
            throw new RuntimeException("用户余额不足！");
        }
        // 4.扣减余额 update tb_user set balance = balance - ?
        int remainBalance = user.getBalance() - money;

        // 方式1 手写sql,不用导入UserMapper 接口了，因为已经继承了， baseMapper就是 userMapper
       /* baseMapper.deuctBanlance(id,money);*/

        // 方式2 lambdaUpdate
        lambdaUpdate()
                .set(User::getBalance, remainBalance)
                .set(remainBalance == 0, User::getStatus, UserStatus.FROZEN)
                .eq(User::getId, id)
                .eq(User::getBalance, user.getBalance()) // 乐观锁
                .update();
    }

    /*复杂条件查询*/
    @Override
    public List<User> queryUsers(String name, Integer status, Integer minBalance, Integer maxBalance) {
        //使用lambdaQuery不用new Wrapper 对象

        /*如果是null，就不看这个条件了*/
        List<User> list = lambdaQuery()
                .like(name != null, User::getUsername, name)
                .eq(status != null, User::getStatus, status)
                .ge(minBalance != null, User::getBalance, maxBalance)
                .le(maxBalance != null, User::getBalance, minBalance)
                .list();

        return list;
    }
}




