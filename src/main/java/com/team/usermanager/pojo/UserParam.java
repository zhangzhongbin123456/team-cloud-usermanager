package com.team.usermanager.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author: Created By Zzbin
 * @version: v1.0
 * @date: 2019/12/25
 */
@Data
public class UserParam {

    @ApiModelProperty(value = "用户账号", dataType = "String", name = "userName")
    @NotBlank(message = "用户id不能为空")
    public String userName;

    @ApiModelProperty(value = "用户密码", dataType = "String", name = "passWord", example = "123456")
    public String passWord;

    @ApiModelProperty(value = "用户姓名", dataType = "String", name = "name")
    public String name;

    @ApiModelProperty(value = "手机号", dataType = "Long", name = "phone")
    public Long phone;


}
