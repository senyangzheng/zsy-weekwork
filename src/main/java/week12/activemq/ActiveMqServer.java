package week12.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

/**
 * @projectName: zsy-weekwork
 * @package: week12.activemq
 * @className: ActiveMqServer
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/24 03:02
 */
public class ActiveMqServer {

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(true, Session.SESSION_TRANSACTED);
        Queue queue = session.createQueue("yy-ds");
        MessageProducer messageProducer = session.createProducer(queue);
        Message message = session.createTextMessage("yiersansiwuliu");
        messageProducer.send(message);
        session.commit();
        messageProducer.close();
        session.close();
        connection.close();
        System.out.println("消息发送成功！！！");
    }
}
