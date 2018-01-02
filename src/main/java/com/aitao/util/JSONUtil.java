package com.aitao.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by caowei on 15-10-27.
 */
public class JSONUtil {
    /**
     * 描述：组装json格式返回结果 创建人：fengsen 创建时间：2012-8-22 备注：.
     * @param isOk
     * @param resCode
     * @param errorMsg
     * @param obj
     * @return
     */
    public static Map<String, Object> createJson(boolean isOk, int resCode, String errorMsg, Object obj) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put("status", isOk ? 1 : 0);
        jsonMap.put("code", resCode);
        jsonMap.put("msg", errorMsg);
        jsonMap.put("data", obj);
        return jsonMap;
    }

    /**
     * 描述：组装json格式返回结果 创建人：fengsen 创建时间：2012-8-22 备注：.
     * @param isOk
     * @param resCode
     * @param errorMsg
     * @param obj
     * @return
     */
    public static String createJsonString(boolean isOk, int resCode, String errorMsg, Object obj) {
        Map<String, Object> jsonMap = createJson(isOk, resCode, errorMsg, obj);
        return ObjectMapperUtil.writeValueAsString(jsonMap);
    }

}
