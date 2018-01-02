package com.aitao.domain.form;

import com.aitao.domain.exception.AiTaoException;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;

/**
 * Created by sunyu on 2017/9/9.
 */
@Data
public class SubmitOrderForm extends BaseForm{
    @ApiModelProperty(value = "淘宝订单编号",required = true)
    private String orderid;

    @Override
    public void checkParam() throws AiTaoException {
        if (StringUtils.isEmpty(orderid)){
            throw new AiTaoException("请输入要提交的淘宝订单编号");
        }
        super.checkParam();
    }
}
