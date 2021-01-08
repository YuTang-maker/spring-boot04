package com.aa;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

/**
 * @author: 挥剑可以留住落樱吗
 * @create: 2021-01-05 16:53
 */
// springboot继承activmq
@EnableJms
@SpringBootApplication
// springboot继承dubbo
@EnableDubbo
public class ControllerMain {

	public static void main(String[] args) {
		SpringApplication.run(ControllerMain.class, args);
	}

}
