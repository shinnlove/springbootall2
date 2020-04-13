/**
 * eBay.com Inc.
 * Copyright (c) 1995-2020 All Rights Reserved.
 */
package com.shinnlove.springbootall.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author Tony Zhao
 * @version $Id: KafkaService.java, v 0.1 2020-04-12 10:49 PM tony, zhao Exp $$
 */
@Service
public class KafkaService implements InitializingBean {

    private static final Logger           LOGGER = LoggerFactory.getLogger(KafkaService.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "test", groupId = "myTopicGroupId")
    public void getOneMessage(ConsumerRecord<String, String> record) {
        String topic = record.topic();
        int partition = record.partition();
        long offset = record.offset();
        String key = record.key();
        String value = record.value();
        System.out.println("Consumer myTopicGroupId receives message from kafka: topic=" + topic
                           + ", partition=" + partition + ", offset=" + offset + ", key=" + key
                           + ", value=" + value);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        String topic = "test";
        String key = "tony";
        String data = "another information";
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, key, data);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                RecordMetadata metadata = result.getRecordMetadata();
                String t = metadata.topic();
                int partition = metadata.partition();
                long offset = metadata.offset();
                System.out
                    .println("topic=" + t + ", partition=" + partition + ", offset=" + offset);
            }

            @Override
            public void onFailure(Throwable ex) {
                ex.printStackTrace();
            }
        });
    }

}