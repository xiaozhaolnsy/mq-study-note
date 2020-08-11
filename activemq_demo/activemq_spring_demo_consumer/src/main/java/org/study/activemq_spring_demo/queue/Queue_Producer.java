package org.study.activemq_spring_demo.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.TextMessage;

@Component
public class Queue_Producer {

    @JmsListener(destination = "${myqueue}")
    public void recieve(TextMessage textMessage) throws Exception{
        System.out.println(textMessage.getText());
    }

}
