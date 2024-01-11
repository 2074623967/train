package com.muke.req;


import org.hibernate.validator.constraints.NotBlank;

/**
 * 会员注册接收类
 *
 * @author tangcj
 * @date 2024/01/11 15:07
 **/
public class MemberRegisterReq {

    @NotBlank(message = "【手机号】不能为空")
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "MemberRegisterReq{" +
                "mobile='" + mobile + '\'' +
                '}';
    }
}
