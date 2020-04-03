/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.shinnlove.springbootall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shinnlove.jinsheng
 * @version $Id: KafkaController.java, v 0.1 2020-04-03 10:26 下午 shinnlove.jinsheng Exp $$
 */
@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @GetMapping("/message/send")
    public boolean send(@RequestParam String message) {
        kafkaTemplate.send("testTopic", message);
        return true;
    }

}