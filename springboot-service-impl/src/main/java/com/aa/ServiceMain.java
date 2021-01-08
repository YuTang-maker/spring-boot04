package com.aa;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: 挥剑可以留住落樱吗
 * @create: 2021-01-05 16:20
 */
@EnableDubbo
@SpringBootApplication
@MapperScan({"com.aa.dao"})
public class ServiceMain {

	public static void main(String[] args) {
		SpringApplication.run(ServiceMain.class, args);
	}

}
