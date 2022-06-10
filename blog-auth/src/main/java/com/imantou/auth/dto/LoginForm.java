package com.gaobug.auth.dto;

import com.gaobug.verify.Verify;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginForm {
    @Verify(required = true, errorMsg = "用户名不能为空")
    private String username;
    @Verify(required = true, errorMsg = "密码不能为空")
    private String password;
    private Integer captcha;
}
