package com.aitao.controller;

import com.aitao.domain.form.LoginForm;
import com.aitao.domain.form.RegisterForm;
import com.aitao.domain.form.ResetPassForm;
import com.aitao.domain.po.User;
import com.aitao.domain.po.UserReturn;
import com.aitao.service.UserService;
import com.aitao.util.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.Map;

/**
 * Created by sunyu on 2017/9/2.
 */
@RestController
@RequestMapping("/user")
@Api(value = "/user",description = "用户相关")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录",httpMethod = "POST")
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    Map<String,Object> login(@RequestParam String parameter) throws Exception {

        LoginForm form = this.check(parameter,LoginForm.class);
        User user = userService.queryByNickName(form.getName());
        if (user == null){
            return this.failResult("请输入正确的登录名密码");
        }
        if (!user.getPassword().equals(form.getPassword())){
            return this.failResult("请输入正确的登录名密码");
        }
        if (user.getState() == 0){
            return this.failResult("用户状态不正确，无法登录");
        }
        UserReturn userReturn = new UserReturn();
        BeanUtils.copyProperties(user,userReturn);
        return this.successDataResult(userReturn);
    }

    @ApiOperation(value = "注册",httpMethod = "POST")
    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    Map<String,Object> register(@RequestParam String parameter) throws Exception {
        RegisterForm form = this.check(parameter,RegisterForm.class);
        User user = userService.queryByNickName(form.getName());
        if (user != null){
            return this.failResult("登录名已存在");
        }
        if (!StringUtils.isEmpty(form.getAli())){
            user = userService.queryByAli(form.getAli());
            if (user != null){
                return this.failResult("支付宝账户已存在");
            }
        }
        if (!StringUtils.isEmpty(form.getWechat())){
            user = userService.queryByWechat(form.getWechat());
            if (user != null){
                return this.failResult("微信账户已存在");
            }
        }
        user = new User();
        user.setAddTime(new Date());
        user.setState(1);
        user.setName(form.getName());
        user.setPassword(form.getPassword());
        user.setAli(form.getAli());
        user.setWechat(form.getWechat());
        user.setToken(MD5Util.encode(form.getName()+form.getPassword()+user.getAddTime()));
        userService.insert(user);
        return this.successResult();
    }

    @ApiOperation(value = "重置密码",httpMethod = "POST")
    @RequestMapping(value = "/resetPass", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    Map<String,Object> resetPass(@RequestParam String parameter) throws Exception {
        ResetPassForm form = this.check(parameter,ResetPassForm.class);
        User user = userService.queryByNickName(form.getName());
        if (user == null){
            return this.failResult("用户不存在");
        }
        if (form.getType() == 1){
            if (!user.getWechat().equals(form.getTypeCode()))
                return this.failResult("微信账号不正确");
        } else if (form.getType() == 2){
            if (!user.getAli().equals(form.getTypeCode()))
                return this.failResult("支付宝账号不正确");
        } else {
            return this.failResult("验证方式不正确");
        }

        User update = new User();
        update.setId(user.getId());
        update.setPassword(form.getPassword());
        update.setToken(MD5Util.encode(form.getName()+form.getPassword()+user.getAddTime()));
        userService.update(update);
        return this.successResult();
    }

//    @ApiOperation(value = "重置密码1",httpMethod = "POST")
//    @RequestMapping(value = "/batchTest", method = {RequestMethod.GET, RequestMethod.POST})
//    public @ResponseBody
//    Map<String,Object> batchTest(){
//        this.userService.batchInsert();
//        return this.successResult();
//    }
//
//    @ApiOperation(value = "重置密码2",httpMethod = "POST")
//    @RequestMapping(value = "/batchInsertTest", method = {RequestMethod.GET, RequestMethod.POST})
//    public @ResponseBody
//    Map<String,Object> batchInsertTest(){
//        this.userService.batchInsertUser();
//        return this.successResult();
//    }
}
