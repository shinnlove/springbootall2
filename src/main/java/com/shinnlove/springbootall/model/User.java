/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.springbootall.model;

import javax.persistence.*;

/**
 * JPA实体类——User。
 *
 * @author shinnlove.jinsheng
 * @version $Id: User.java, v 0.1 2018-07-21 下午9:20 shinnlove.jinsheng Exp $$
 */
@Entity
@Table(name = "user")
public class User {

    /** JPA的模型必须有一个字段标注主键，这里主键是自增的 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int    id;

    private String name;

    private String password;

    private int    age;

    public User() {
    }

    public User(int id, String name, String password, int age) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
    }

    /**
     * Getter method for property id.
     *
     * @return property value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for property id.
     *
     * @param id value to be assigned to property id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter method for property name.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property name.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property password.
     *
     * @return property value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for property password.
     *
     * @param password value to be assigned to property password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter method for property age.
     *
     * @return property value of age
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter method for property age.
     *
     * @param age value to be assigned to property age
     */
    public void setAge(int age) {
        this.age = age;
    }

}