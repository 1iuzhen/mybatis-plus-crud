package com.zhenbang.demo02mybatisplus.controller;



import cn.hutool.core.bean.BeanUtil;


import cn.hutool.json.JSONUtil;
import com.zhenbang.demo02mybatisplus.domain.dto.UserFormDTO;
import com.zhenbang.demo02mybatisplus.domain.po.User;
import com.zhenbang.demo02mybatisplus.domain.query.UserQuery;
import com.zhenbang.demo02mybatisplus.domain.vo.UserVO;
import com.zhenbang.demo02mybatisplus.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "用户管理接口", description = "用户的增删改查相关接口")
@RequestMapping("/users")
@RestController

public class UserController {

    @Resource
    private  UserService userService;

    @Operation(summary = "新增用户接口")
    @PostMapping
    public void saveUser(@RequestBody UserFormDTO userDTO){
        System.out.println(userDTO);
        // 前端传过来对象，其中一个属性字段为json,自动转化为对象吗
        User user = BeanUtil.copyProperties(userDTO, User.class);
        userService.save(user);
    }

    @Operation(summary = "删除用户接口")
    @DeleteMapping("/{id}")
    public void deleteUserById(
            @Parameter(description = "用户id") @PathVariable("id") Long id){
        userService.removeById(id);
    }

    @Operation(summary = "根据id查询用户接口")
    @GetMapping("/{id}")
    public UserVO queryUserById(
            @Parameter(description = "用户id") @PathVariable("id") Long id){

        System.out.println(id);
        User user = userService.getById(id);
        System.out.println(user);

        UserVO userVO = BeanUtil.copyProperties(user, UserVO.class);
        System.out.println(userVO);
        return userVO;
    }

    @Operation(summary = "根据id批量查询用户接口")
    @GetMapping
    public List<UserVO> queryUserByIds(
            @Parameter(description = "用户id集合") @RequestParam("ids") List<Long> ids){

        List<User> users = userService.listByIds(ids);
        return BeanUtil.copyToList(users, UserVO.class);

    }

 @Operation(summary = "扣减用户余额接口")
    @PutMapping("/{id}/deduction/{money}")
    public void deductBalance(
            @Parameter(description = "用户id") @PathVariable("id") Long id,
            @Parameter(description = "扣减的金额") @PathVariable("money") Integer money){
        userService.deductBalance(id, money);
    }

    @Operation(summary = "根据复杂条件查询用户接口")
    @GetMapping("/list")
    /*如果查询条件参数过多，就用对象*/
    public List<UserVO> queryUsers(UserQuery query){
        List<User> users = userService.queryUsers(
                query.getName(), query.getStatus(), query.getMinBalance(), query.getMaxBalance());
        return BeanUtil.copyToList(users, UserVO.class);
    }

 /*   @Operation(summary = "根据条件分页查询用户接口")
    @GetMapping("/page")
    public PageDTO<UserVO> queryUsersPage(UserQuery query){
        return userService.queryUsersPage(query);
    }*/
}
