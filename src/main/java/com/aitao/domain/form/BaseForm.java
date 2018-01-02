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
public class BaseForm extends Base{

    @ApiModelProperty(value = "用户编号",required = true)
    private Integer uid;

    @ApiModelProperty(value = "token",required = true)
    private String token;

    public void checkParam() throws AiTaoException {
        if (uid == null){
            throw new AiTaoException("请输入用户编号");
        }
        if (StringUtils.isEmpty(token)){
            throw new AiTaoException("请输入token");
        }
    }
}
