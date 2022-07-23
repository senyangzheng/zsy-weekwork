package week12.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @projectName: zsy-weekwork
 * @package: week12.activemq
 * @className: ActiveMqClient
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/24 03:03
 */
public class ActiveMqClient {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(true, Session.SESSION_TRANSACTED);
        Queue queue = session.createQueue("yy-ds");
        MessageConsumer messageConsumer = session.createConsumer(queue);
        while (true) {
            TextMessage message = (TextMessage) messageConsumer.receive(1000);
            if (message != null) {
                System.out.println(message.getText());
            } else {
                break;
            }
        }
        session.commit();
        session.close();
        connection.close();
        System.out.println("消息消费结束！！！");
    }
}
