package com.aitao.domain.form;

import com.aitao.domain.exception.AiTaoException;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.util.StringUtils;

/**
 * Created by sunyu on 2017/9/9.
 */
@Data
public class LoginForm extends Base{

    @ApiModelProperty(value = "登录名",required = true)
    private String name;
    @ApiModelProperty(value = "密码",required = true)
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
        super.checkParam();
    }
}
