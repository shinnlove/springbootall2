/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.springbootall.repository;

import java.util.List;

import com.shinnlove.springbootall.model.User;

/**
 * 用户查询仓储。
 *
 * @author shinnlove.jinsheng
 * @version $Id: UserService.java, v 0.1 2018-07-21 下午5:05 shinnlove.jinsheng Exp $$
 */
public interface UserService {

    int addUser(User user);

    User findUserById(int userId);

    List<User> findAllUser(int pageNum, int pageSize);

}