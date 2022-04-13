package com.spring.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component

public class MessageSender {

	@Autowired 
	JmsTemplate template;
	
	public void sendMessage(final String message)
	{
		template.send(new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				ObjectMessage objMessage=session.createObjectMessage(message);
				return objMessage;
			}
			
		}
				);
	}
	
	public void sendObject(final Product product)
	{
		template.send(new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				ObjectMessage objMessage=session.createObjectMessage(product);
				return objMessage;
			}
			
		}
				);
	}
	
}
