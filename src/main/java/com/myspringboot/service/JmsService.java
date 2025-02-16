package com.myspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JmsService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${ibm.mq.queue}")
    private String queue;

    @Value("${ibm.mq.connName}")
    private String connName;

    public String send(String message) {
        try {
            jmsTemplate.convertAndSend(queue, message);
            return "{ \"message\" : \"Message Sent: " + message + "\" }";
        } catch (JmsException ex) {
            ex.printStackTrace();
            return "{ \"message\" : \"Error occurred while sending message: " + message + "\" }";
        }
    }

    public String receive(){
        try{
            String message = jmsTemplate.receiveAndConvert(queue).toString();
            return "{ \"message\" : \"Message Received: " + message + "\" }";
        } catch(JmsException ex){
            ex.printStackTrace();
            return "{ \"message\" : \"Error occurred while receiving message\" }";
        }
    }

    public String address() {
        try {
            String address_0 = connName.split("\\(")[0];;
            return "{ \"message\" : \""+ address_0 +"\" }";
        } catch(Exception e) {
            return "{ \"message\" : \"Please ensure that your application.properties file is set up correctly.\" }";
        }

    }

}
