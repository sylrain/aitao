package com.aitao.domain.form;

import com.aitao.domain.exception.AiTaoException;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;

/**
 * Created by sunyu on 2017/9/9.
 */
@Data
public class ResetPassForm extends Base{

    @ApiModelProperty(value = "登录名",required = true)
    private String name;

    @ApiModelProperty(value = "验证方式 1微信 2支付宝",required = true)
    private Integer type;

    @ApiModelProperty(value = "验证的code",required = true)
    private String typeCode;

    @ApiModelProperty(value = "欲重置的密码",required = true)
    private String password;

    @Override
    public void checkParam() throws AiTaoException {
        if (StringUtils.isEmpty(name)){
            throw new AiTaoException("请输入登录名");
        }
        if (StringUtils.isEmpty(password)){
            throw new AiTaoException("请输入密码");
        }
        if (name.length() < 6 || name.length() > 20){
            throw new AiTaoException("登录名长度不对");
        }
        if (password.length() < 8 || password.length() > 16){
            throw new AiTaoException("密码长度不对");
        }
        if (type == null){
            throw new AiTaoException("请选择正确的验证方式");
        }
        if (StringUtils.isEmpty(typeCode)){
            throw new AiTaoException("请输入密码");
        }
        super.checkParam();
    }
}
