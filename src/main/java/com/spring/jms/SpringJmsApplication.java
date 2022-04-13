package com.spring.jms;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.Message;
import org.apache.activemq.broker.Connection;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class SpringJmsApplication {
	
//private static String url=ActiveMQConnection.DEFAULT_BROKER_URL;
//	
//	private static String queueName="Message_Queue";

	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(SpringJmsApplication.class, args);
		System.out.println("hello this is spring jms application");

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MessageSender sender=(MessageSender) context.getBean("messageSender");
		Product product=new Product(1,"table",100);
		sender.sendObject(product);
		sender.sendMessage("hello ris.... hope you are doing fine....");
		System.out.println("message has been sent successfully....");
		
		
//		MessageReceiver receiver = (MessageReceiver) context.getBean("messageReceiver");
//		Product prod=receiver.receiveProduct();
////		String response = receiver.receiveMessage();
//		System.out.println("message receiver....."+ "...."+prod);
	
//		System.out.println("url ..."+url);
//		
//		ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory("admin","amdin","failover://tcp://localhost:61616");
//		
////		((ActiveMQConnection) factory).setUserName("admin");
////		  ((ActiveMQConnection) factory).setPassword("admin");
//		ActiveMQConnection connection=(ActiveMQConnection) factory.createConnection();
//		connection.start();
//		
//		Session session=( (connection)).createSession(false,Session.AUTO_ACKNOWLEDGE);
//		Destination destination=session.createQueue(queueName);
//		
//		MessageProducer producer=session.createProducer(destination);
//		TextMessage message=session.createTextMessage("hi rishabh....how are you");
//		
//		producer.send(message);
//		System.out.println("Message..... "+message.getText()+" sent successFully to queue");
//		
//		MessageConsumer consumer=session.createConsumer(destination);
//		Message msg=(Message) consumer.receive();
//		if(msg instanceof TextMessage)
//		{
//		   TextMessage txtmsg=message;
//		   System.out.println("received msg..."+txtmsg.getText()+"  ");
//		}
//		connection.close();
	}

}
