/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.springbootall.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shinnlove.springbootall.model.User;

import javax.persistence.Table;

/**
 * JPA仓储。
 *
 * @author shinnlove.jinsheng
 * @version $Id: UserRepository.java, v 0.1 2018-07-21 下午9:23 shinnlove.jinsheng Exp $$
 */
@Repository
@Table(name = "user")
@Qualifier("userRepository")
public interface UserRepository extends CrudRepository<User, Integer> {

    User findUserById(Integer id);

    @Override
    @SuppressWarnings("unchecked")
    User save(User u);

    @Query("select t from User t where t.name=:name")
    User findUserByName(@Param("name") String name);

}