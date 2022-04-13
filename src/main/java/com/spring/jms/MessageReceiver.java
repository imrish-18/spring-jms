package com.spring.jms;

import org.apache.activemq.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

	@Autowired
	JmsTemplate template;
	@Autowired
	MessageConverter converter;
	
//	public String receiveMessage()
//	{
//		try
//		{
//			Message msg=(Message) template.receive();
//			String response=(String) converter.fromMessage(msg);
//			return response;
//		}
//		catch(Exception ex)
//		{
//			ex.printStackTrace();
//		}
//		return null;
//	}

	public Product receiveProduct()
	{
		try
		{
			Message msg=(Message) template.receive();
			Product response=(Product) converter.fromMessage(msg);
			System.out.println(response);
			return response;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
}
