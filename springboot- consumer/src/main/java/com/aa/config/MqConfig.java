package com.aa.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;
import javax.jms.Topic;
import javax.management.Query;

/**
 * 消息中间件
 *
 * @author: 挥剑可以留住落樱吗
 * @create: 2021-01-05 19:35
 */
@Configuration
public class MqConfig {

	/**
	 * 创建点对点队列
	 *
	 * @return
	 */
	@Bean
	public Queue updateUser() {
		return new ActiveMQQueue("updateUser");
	}

	/**
	 * 创建订阅队列
	 *
	 * @return
	 */
	@Bean
	public Topic t1() {
		return new ActiveMQTopic("t1");
	}

}
