package com.spring.jms;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages="com.spring.jms")
@Import(MessagingConfiguration.class)
public class AppConfig {

}
