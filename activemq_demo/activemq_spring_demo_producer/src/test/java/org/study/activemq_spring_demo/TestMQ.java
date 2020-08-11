package org.study.activemq_spring_demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.study.activemq_spring_demo.queue.Queue_Producer;

import javax.annotation.Resource;

@SpringBootTest(classes = ActivemqSpringDemoApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestMQ {

    @Resource
    private Queue_Producer queue_producer;

    @Test
    public void testSend() throws Exception{
        queue_producer.produceMsg();
    }

    @Test
    public void testSendScheduled() throws Exception{
        queue_producer.produceMsgScheduled();
    }

}
