/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.shinnlove.springbootall.service.rocketmq.basic;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 在spring-boot中不用模板直接使用RocketMQ。
 *
 * @author shinnlove.jinsheng
 * @version $Id: ProducerService.java, v 0.1 2018-09-02 下午4:13 shinnlove.jinsheng Exp $$
 */
@Service(value = "producerService")
public class ProducerService {

    /** NameServer */
    private static final String NAME_SERVER = "192.168.0.106:9876";

    /** 生产者分组 */
    private static final String GROUP_NAME  = "producerGroupName";

    private DefaultMQProducer   producer    = null;

    @PostConstruct
    public void initMQProducer() {
        // 生产者配置
        producer = new DefaultMQProducer(GROUP_NAME);
        producer.setNamesrvAddr(NAME_SERVER);
        producer.setRetryTimesWhenSendFailed(3);

        try {
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    public void send(String topic, String msg) {
        Message oneMessage = new Message(topic, "", "", msg.getBytes());
        try {
            producer.send(oneMessage);
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void shutDownProducer() {
        if (producer != null) {
            producer.shutdown();
        }
    }

}