import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class JMSConsumer {

    private static final String ACTIVEMQ_URL="tcp://10.10.100.20:61617";
    private static final String QUEUE_NAME="queue01";

    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("2");
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_NAME);
        MessageConsumer messageConsumer = session.createConsumer(queue);
//        while(true){
//            TextMessage textMessage=(TextMessage)messageConsumer.receive();
//            if(textMessage != null){
//                System.out.println(("recieve"+textMessage.getText()));
//            }
//            else{
//                break;
//            }
//        }

        // 监听
        messageConsumer.setMessageListener((message)->{
            if(null != message && message instanceof TextMessage){
                TextMessage textMessage = (TextMessage)message;
                try {
                    System.out.println(textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        System.in.read();
        messageConsumer.close();
        session.close();
        connection.close();
    }

}
