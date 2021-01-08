package com.aa.ActivMQListener;

import com.aa.entity.TbItem;
import com.aa.entity.User;
import com.aa.service.IUserService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: 挥剑可以留住落樱吗
 * @create: 2021-01-05 19:51
 */
@Component
@Slf4j
public class ActivMqListener {

	@Resource
	private IUserService userService;


	@SendTo("SQueue")

	@JmsListener(destination = "updateUser")
	public String ListenerupdateUser(String userStr) {
		try {
			userService.updateUserById(JSON.parseObject(userStr, User.class));
			log.info("修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("修改失败");
		}
		return "101";
	}

}
