package com.aitao.controller;

import com.aitao.domain.exception.AiTaoException;
import com.aitao.domain.form.Base;
import com.aitao.domain.form.BaseForm;
import com.aitao.domain.form.BaseQueryForm;
import com.aitao.util.JSONUtil;
import com.aitao.util.ObjectMapperUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sunyu on 2017/9/2.
 */
public class BaseController {
    /**
     * 系统日志配置.
     */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 成功的Status Code.
     */
    private static final int RESCODE_OK = 20000;
    /**
     * 失败的Status Code.
     */
    private static final int RESCODE_FAIL = 20001;
    /**
     * 运行期异常控制
     *
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public
    @ResponseBody
    Map<String, Object> runtimeExceptionHandler(RuntimeException e) {
        logger.error("发生系统异常", e);
        return this.failResult("系统异常，请和管理员联系！");
    }

    @ExceptionHandler(BindException.class)
    public
    @ResponseBody
    Map<String, Object> bindExceptionHandler(BindException e) {
        logger.error(e.getLocalizedMessage());
        return this.failResult(e.getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(AiTaoException.class)
    public
    @ResponseBody
    Map<String, Object> aitaoExceptionHandler(AiTaoException e) {
        logger.error(e.getMessage());
        return this.failResult(e.getMessage());
    }
    /**
     * 获取失败信息.
     *
     * @param msg
     * @return
     */
    protected Map<String, Object> failResult(String msg) {
        return JSONUtil.createJson(false, RESCODE_FAIL, msg, Collections.EMPTY_MAP);
    }

    /**
     * 获取失败信息.
     *
     * @param msg
     * @return
     */
    protected Map<String, Object> failResult(int errCode, String msg) {
        return JSONUtil.createJson(false, errCode, msg, Collections.EMPTY_MAP);
    }

    /**
     * 获取成功信息.
     * 只返回数据，默认操作信息为操作成功
     *
     * @param obj
     * @return
     */
    protected Map<String, Object> successDataResult(Object obj) {
        return JSONUtil.createJson(true, RESCODE_OK, "操作成功", obj);
    }

    /**
     * 获取默认ajax成功信息.
     *
     * @return
     */
    protected Map<String, Object> successResult() {
        return JSONUtil.createJson(true, RESCODE_OK, "操作成功！", Collections.EMPTY_MAP);
    }

    protected Map<String,Object> getPageResponse(BaseQueryForm form, int totalCount, List dataList){
        Map<String,Object> retMap = new HashMap<>();
        retMap.put("pageNum",form.getPageNum());
        retMap.put("pageSize",form.getPageSize());
        retMap.put("totalCount",0);
        retMap.put("dataList",dataList);
        return retMap;
    }

    protected <T extends Base>T check(String paramter, Class<T> classType) throws Exception{
        T o = ObjectMapperUtil.readValue(paramter,classType);
        o.checkParam();
        return o;
    }
}
