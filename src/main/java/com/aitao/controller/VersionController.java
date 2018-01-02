package com.aitao.controller;

import com.aitao.service.VersionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by sunyu on 2017/9/9.
 */
@RestController
@RequestMapping("/version")
@Api(value = "/version",description = "版本相关")
public class VersionController extends BaseController{

    @Autowired
    private VersionService versionService;

    @ApiOperation(value = "查询列表",httpMethod = "POST")
    @RequestMapping(value = "/query", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    Map<String,Object> query(){
        return this.successDataResult(versionService.query());
    }
}
