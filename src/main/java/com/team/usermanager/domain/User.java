package com.team.usermanager.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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
