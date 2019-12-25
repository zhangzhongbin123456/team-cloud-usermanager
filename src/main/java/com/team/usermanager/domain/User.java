package com.team.usermanager.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author: Created By Zzbin
 * @version: v1.0
 * @date: 2019/12/10
 */
@Data
@ApiModel
@Entity
@Table(name = "T_USER_ACCOUNT")
public class User implements Serializable {

    @ApiModelProperty(value = "用户id", dataType = "String", name = "uid", example = "UUID")
    @NotBlank(message = "用户id不能为空")
    private String uid;

    /**
     * 用户唯一编码
     */
    @ApiModelProperty(value = "用户唯一编码", dataType = "String", name = "union_id")
    @NotBlank(message = "用户唯一编码不能为空")
    private String unionId;

    /**
     * 部门
     */
    @ApiModelProperty(value = "部门", dataType = "Integer", name = "dept_id", example = "null")
    private Integer deptId;

    /**
     * 分组
     */
    @ApiModelProperty(value = "分组", dataType = "Integer", name = "group_id", example = "null")
    private Integer groupId;

    /**
     * 机构
     */
    @ApiModelProperty(value = "机构", dataType = "Integer", name = "unit_id", example = "null")
    private Integer unitId;

    /**
     * 用户凭证
     */
    @ApiModelProperty(value = "用户凭证", dataType = "String", name = "token", example = "null")
    private String token;

    /**
     * 用户密码
     */
    @ApiModelProperty(value = "用户密码", dataType = "String", name = "password")
    @NotBlank(message = "户密码不能为空")
    private String password;

    /**
     * 用户姓名
     */
    @ApiModelProperty(value = "用户姓名", dataType = "String", name = "name", example = "null")
    private String name;

    /**
     * 身份证号
     */
    @ApiModelProperty(value = "身份证号", dataType = "String", name = "id_card", example = "null")
    private String idCard;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号", dataType = "Integer", name = "phone", example = "null")
    private Long phone;

    /**
     * 微信标识
     */
    @ApiModelProperty(value = "微信标识", dataType = "String", name = "open_id", example = "null")
    private String openId;

    /**
     * 头像地址
     */
    @ApiModelProperty(value = "头像地址", dataType = "String", name = "avatar_url", example = "null")
    private String avatarUrl;

    /**
     * 创建时间
     */
    @CreationTimestamp
    @ApiModelProperty(value = "创建时间", dataType = "Timestamp", name = "created_time", example = "NOW()")
    private Timestamp createdTime;

    /**
     * 修改时间
     */
    @UpdateTimestamp
    @ApiModelProperty(value = "修改时间", dataType = "Timestamp", name = "updated_time", example = "NOW()")
    private Timestamp updatedTime;

    /**
     * 删除时间
     */
    @ApiModelProperty(value = "删除时间", dataType = "Timestamp", name = "deleted_time", example = "null")
    private Timestamp deletedTime;

    public User() {
    }

    public User(@NotBlank(message = "用户id不能为空") String uid, @NotBlank(message = "用户唯一编码不能为空") String unionId, Integer deptId, Integer groupId, Integer unitId, String token, @NotBlank(message = "户密码不能为空") String password, String name, String idCard, Long phone, String openId, String avatarUrl, Timestamp createdTime, Timestamp updatedTime, Timestamp deletedTime) {
        this.uid = uid;
        this.unionId = unionId;
        this.deptId = deptId;
        this.groupId = groupId;
        this.unitId = unitId;
        this.token = token;
        this.password = password;
        this.name = name;
        this.idCard = idCard;
        this.phone = phone;
        this.openId = openId;
        this.avatarUrl = avatarUrl;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.deletedTime = deletedTime;
    }
}
