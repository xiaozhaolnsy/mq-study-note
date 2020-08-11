import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSProduce {

//    private static final String ACTIVEMQ_URL="tcp://10.10.100.20:61617";
    private static final String ACTIVEMQ_URL="tcp://localhost:61616";
    //private static final String USERNAME="admin";
    private static final String QUEUE_NAME="queue01";

    public static void main(String[] args) throws JMSException {
        //1 创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //2 通过连接工厂 获得连接Connection 并启动
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //3 创建会话
        //两个参数，1事务 2签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4 创建目的地（QUEUE or TOPIC）
        //Destination destination = session.createQueue(QUEUE_NAME);
        Queue queue = session.createQueue(QUEUE_NAME);
        //5 创建消息生产者
        MessageProducer messageProducer = session.createProducer(queue);
        //6 生产消息送到队列
        for (int i = 1; i <= 3; i++){
            //7 创建消息
            TextMessage textMessage = session.createTextMessage("msg----"+i);
            //8 通过生成者发送给mq
            messageProducer.send(textMessage);
        }
        //9 关闭资源
        messageProducer.close();
        session.close();
        connection.close();


    }

}
