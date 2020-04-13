/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.shinnlove.springbootall.controller;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shinnlove.springbootall.util.code.SystemResultCode;
import com.shinnlove.springbootall.util.exception.SystemException;
import com.shinnlove.springbootall.util.log.LoggerUtil;

/**
 * Kafka Producer Controller.
 * 
 * @author shinnlove.jinsheng
 * @version $Id: KafkaController.java, v 0.1 2020-04-03 10:26 下午 shinnlove.jinsheng Exp $$
 */
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private static final Logger           LOGGER = LoggerFactory.getLogger(KafkaController.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/send")
    public String send(@RequestParam String message) {
        String topic = "test";
        String key = "tony";

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, key,
            message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                String info = readSendResult(result);
                System.out.println(info);
                LoggerUtil.info(LOGGER, info);
            }

            @Override
            public void onFailure(Throwable ex) {
                LoggerUtil.error(LOGGER, ex, ex);
            }
        });

        try {
            return readSendResult(future.get());
        } catch (Exception e) {
            throw new SystemException(SystemResultCode.SYSTEM_ERROR, e, e.getMessage());
        }
    }

    /**
     * Read message from kafka producer result.
     * 
     * @param result 
     * @return
     */
    private String readSendResult(SendResult<String, String> result) {
        StringBuilder sb = new StringBuilder();
        RecordMetadata metadata = result.getRecordMetadata();
        String topic = metadata.topic();
        int partition = metadata.partition();
        long offset = metadata.offset();
        long timestamp = metadata.timestamp();
        sb.append("message has been sent, topic=").append(topic);
        sb.append(", partition=").append(partition);
        sb.append(", offset=").append(offset);
        sb.append(", timestamp=").append(timestamp);
        return sb.toString();
    }

}