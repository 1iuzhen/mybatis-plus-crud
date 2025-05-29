package com.zhenbang.demo02mybatisplus.mapper;

import com.zhenbang.demo02mybatisplus.domain.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
* @author Administer
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2025-05-28 14:34:56
* @Entity com.zhenbang.demo02mybatisplus.pojo.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {



    void deuctBanlance(@Param("id") Long id, @Param("money") Integer money);
}




