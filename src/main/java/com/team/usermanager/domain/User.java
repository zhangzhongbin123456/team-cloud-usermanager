package com.team.usermanager.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: Created By Zzbin
 * @version: v1.0
 * @date: 2019/12/10
 */
@Data
@Entity
@Table(name = "T_USER_ACCOUNT")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String uid;

    //用户唯一编码
    private String union_id;

    //部门id
    private Integer dept_id;

    //分组id
    private Integer group_id;

    //机构id
    private Integer unit_id;

    //用户凭证
    private String token;

    //用户密码
    private String password;

    //用户姓名
    private String name;

    //身份证号
    private String id_card;

    //手机号
    private Long phone;

    //微信标识
    private String open_id;

    //头像地址
    private String avatar_url;

    //创建时间
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created_time;

    //修改时间
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updated_time;

    //删除时间
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deleted_time;

    public User() {
    }

    public User(String union_id, Integer dept_id, Integer group_id, Integer unit_id, String token, String password, String name, String id_card, Long phone, String open_id, String avatar_url, Date created_time, Date updated_time, Date deleted_time) {
        this.union_id = union_id;
        this.dept_id = dept_id;
        this.group_id = group_id;
        this.unit_id = unit_id;
        this.token = token;
        this.password = password;
        this.name = name;
        this.id_card = id_card;
        this.phone = phone;
        this.open_id = open_id;
        this.avatar_url = avatar_url;
        this.created_time = created_time;
        this.updated_time = updated_time;
        this.deleted_time = deleted_time;
    }
}
