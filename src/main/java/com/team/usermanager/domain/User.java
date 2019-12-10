package com.team.usermanager.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Created By Zzbin
 * @version: v1.0
 * @date: 2019/12/10
 */
@Data
public class User implements Serializable {

    private Long id;

    private String name;

    private String pwd;

    public User() {
    }

    public User(Long id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }
}
