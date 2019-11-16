/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.shinnlove.springbootall.es.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.shinnlove.springbootall.es.model.IFFOrder;

/**
 * @author shinnlove.jinsheng
 * @version $Id: IFFOrderRepository.java, v 0.1 2019-11-16 10:20 下午 shinnlove.jinsheng Exp $$
 */
@Repository("iffOrderRepository")
public interface IFFOrderRepository extends ElasticsearchRepository<IFFOrder, Long> {

}