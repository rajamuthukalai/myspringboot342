package com.myspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsService {

    public static final String JMS_QUEUE = "DEV.QUEUE.1";
    @Autowired
    private JmsTemplate jmsTemplate;

    public String send() {
        try {
            jmsTemplate.convertAndSend(JMS_QUEUE, "hello");
            return "OK";
        } catch (JmsException ex) {
            ex.printStackTrace();
            return "FAIL";
        }
    }

    public String receive(){
        try{
            return jmsTemplate.receiveAndConvert("DEV.QUEUE.1").toString();
        }catch(JmsException ex){
            ex.printStackTrace();
            return "FAIL";
        }
    }

}
