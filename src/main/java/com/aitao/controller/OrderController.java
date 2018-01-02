package com.aitao.controller;

import com.aitao.domain.condition.OrderDealCondition;
import com.aitao.domain.exception.AiTaoException;
import com.aitao.domain.form.LoginForm;
import com.aitao.domain.form.OrderQueryForm;
import com.aitao.domain.form.SubmitOrderForm;
import com.aitao.domain.po.Order;
import com.aitao.domain.po.OrderDeal;
import com.aitao.domain.po.OrderInfo;
import com.aitao.domain.po.User;
import com.aitao.service.OrderDealService;
import com.aitao.service.OrderService;
import com.aitao.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by sunyu on 2017/9/9.
 */
@RestController
@RequestMapping("/order")
@Api(value = "/order",description = "订单相关")
public class OrderController extends BaseController{
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDealService orderDealService;

    @ApiOperation(value = "提交订单",httpMethod = "POST")
    @RequestMapping(value = "/submit", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    Map<String,Object> submit(@RequestParam String parameter) throws Exception {
        SubmitOrderForm form = this.check(parameter,SubmitOrderForm.class);
        User user = userService.queryWithValid(form.getUid());
        if (!user.getToken().equals(form.getToken())){
            return this.failResult("验证错误");
        }
        if (user.getState() == 0){
            return this.failResult("用户状态不正确");
        }

        Order order = this.orderService.queryByOrderId(form.getOrderid());
        if (order == null){
            return this.failResult("此订单不存在");
        }
        if (!"订单结算".equals(order.getOrderstate()) || !"0".equals(order.getHasrate())){
            return this.failResult("订单还未确认收货或者已经返现");
        }
        OrderDeal deal = this.orderDealService.query(order.getId());
        if (deal != null){
            return this.failResult("此订单已提交过");
        }

        OrderDeal orderDeal = new OrderDeal();
        orderDeal.setId(order.getId());
        orderDeal.setState(0);
        orderDeal.setUid(form.getUid());
        orderDeal.setAddTime(new Date());
        this.orderDealService.insert(orderDeal);

        return this.successResult();
    }

    @ApiOperation(value = "查询列表",httpMethod = "POST")
    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    Map<String,Object> list(@RequestParam String parameter) throws Exception {
        OrderQueryForm form = this.check(parameter,OrderQueryForm.class);
        User user = userService.queryWithValid(form.getUid());
        if (!user.getToken().equals(form.getToken())){
            return this.failResult("验证错误");
        }
        if (user.getState() == 0){
            return this.failResult("用户状态不正确");
        }


        OrderDealCondition dealCondition = new OrderDealCondition();
        dealCondition.setUid(form.getUid());
        dealCondition.setPageNum(form.getPageNum());
        dealCondition.setPageSize(form.getPageSize());
        int totalCount = this.orderDealService.queryCount(dealCondition);
        if (totalCount > 0){
            List<OrderInfo> list = orderDealService.queryInfoList(dealCondition);
            return this.successDataResult(this.getPageResponse(form,totalCount,list));
        }
        return this.successDataResult(this.getPageResponse(form,totalCount,new ArrayList<>()));

    }
}
