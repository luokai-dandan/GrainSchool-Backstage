package com.atguigu.orderservice.client;

import com.atguigu.commonutils.ordervo.UcenterMemberCommon;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import org.springframework.stereotype.Component;

/**
 * @Author luokai
 */
@Component
public class UcenterClientImpl implements UcenterClient{
    @Override
    public UcenterMemberCommon getUserInfo(String id) {
        throw new GuliException(20001,"远程调用查询用户信息异常");
    }
}
