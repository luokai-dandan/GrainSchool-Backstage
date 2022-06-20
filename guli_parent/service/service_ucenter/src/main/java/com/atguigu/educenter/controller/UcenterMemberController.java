package com.atguigu.educenter.controller;


import com.atguigu.commonutils.R;
import com.atguigu.educenter.entity.UcenterMember;
import com.atguigu.educenter.entity.vo.RegisterVo;
import com.atguigu.educenter.entity.vo.PwdLoginVo;
import com.atguigu.educenter.entity.vo.VerCodeLoginVo;
import com.atguigu.educenter.service.UcenterMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author LuoKai
 * @since 2022-06-20
 */
@Api("用户管理")
@RestController
@RequestMapping("/educenter/member")
@CrossOrigin
public class UcenterMemberController {

    @Autowired
    private UcenterMemberService memberService;

    //密码登录
    @PostMapping("loginByPwd")
    @ApiOperation("用户验证码登录接口")
    public R loginByPwd(
            @ApiParam(name = "pwdLoginVo", value = "密码登录对象封装", required = true)
            @RequestBody PwdLoginVo pwdLoginVo) {

        //调用service实现登录，返回token值，使用Jwt生成
        String token = memberService.loginByPwd(pwdLoginVo);
        return R.ok().data("token", token);
    }

    //验证码登录
    @PostMapping("loginByCode")
    @ApiOperation("用户密码登录接口")
    public R loginByCode(
            @ApiParam(name = "verCodeLoginVo", value = "验证码登录对象封装", required = true)
            @RequestBody VerCodeLoginVo verCodeLoginVo) {

        //调用service实现登录，返回token值，使用Jwt生成
        String token = memberService.loginByCode(verCodeLoginVo);
        return R.ok().data("token", token);
    }

    //注册
    @ApiOperation(value = "会员注册")
    @PostMapping("register")
    public R register(
            @ApiParam(name = "registerVo", value = "注册对象封装", required = true)
            @RequestBody RegisterVo registerVo){

        memberService.register(registerVo);
        return R.ok();
    }

    //根据token获取用户信息
    @ApiOperation(value = "解析token获取用户信息")
    @GetMapping("getMemberInfo")
    public R getMemberInfo(
            @ApiParam(name = "request", value = "请求对象", required = true)
            HttpServletRequest request) {

        UcenterMember member = memberService.getMemberInfo(request);
        return R.ok().data("userInfo",member);
    }

    //展示个人信息
    @ApiOperation(value = "展示个人信息")
    @GetMapping("showUserInfo/{userId}")
    public R showUserInfo(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @PathVariable String userId) {

        UcenterMember member = memberService.showUserInfo(userId);
        return R.ok().data("user",member);
    }

}

