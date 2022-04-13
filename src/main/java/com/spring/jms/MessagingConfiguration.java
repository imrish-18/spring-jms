package com.spring.jms;

import java.util.Arrays;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

@Configuration
public class MessagingConfiguration {

	private static String url=ActiveMQConnection.DEFAULT_BROKER_URL;
	private static String queueName="Message_Queue";
//	
//	@Autowired
//	MessageReceiver messageReceiver;
	
	@Bean
	public ConnectionFactory connectionFactory()
	{
	 	ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory("admin","amdin","failover://tcp://localhost:61616");
	      factory.setTrustedPackages(Arrays.asList("com.spring.jms"));
	      return factory;
	}
	
	@Bean
	public JmsTemplate jmsTemplate()
	{
		JmsTemplate template=new JmsTemplate();
		template.setConnectionFactory(connectionFactory());
		template.setDefaultDestinationName(queueName);
		return template;
	}
	@Bean
	public MessageConverter converter()
	{
		return new SimpleMessageConverter();
	}
	
}
