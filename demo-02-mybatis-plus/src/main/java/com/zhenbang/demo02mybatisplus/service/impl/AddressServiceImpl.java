package com.zhenbang.demo02mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhenbang.demo02mybatisplus.domain.po.Address;
import com.zhenbang.demo02mybatisplus.service.AddressService;
import com.zhenbang.demo02mybatisplus.mapper.AddressMapper;
import org.springframework.stereotype.Service;

/**
* @author Administer
* @description 针对表【address】的数据库操作Service实现
* @createDate 2025-05-28 14:28:54
*/
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService{

}




