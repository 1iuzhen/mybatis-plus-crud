package com.zhenbang.demo02mybatisplus.mapper;

import com.zhenbang.demo02mybatisplus.domain.po.Address;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @author Administer
* @description 针对表【address】的数据库操作Mapper
* @createDate 2025-05-28 14:28:54
* @Entity com.zhenbang.demo02mybatisplus.pojo.Address
*/
@Mapper
public interface AddressMapper extends BaseMapper<Address> {

}




