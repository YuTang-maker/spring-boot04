package com.aa.controller;

import com.aa.entity.User;
import com.aa.service.IUserService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.jms.*;
import java.util.List;

/**
 * @author: 挥剑可以留住落樱吗
 * @create: 2021-01-05 16:53
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

	@Reference(timeout = 3000)
	private IUserService userService;

	@Resource
	private JmsTemplate jmsTemplate;

	@Resource
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Resource
	private Queue updateUser;

	@Resource
	private Topic t1;


	/**
	 * 查询user表中所有记录
	 *
	 * @return
	 */
	@GetMapping(value = "/queryAll")
	public List<User> queryUserAll() {
		return userService.queryUserAll();
	}

	/**
	 * 根据id字段查找一条user表中一条记录
	 *
	 * @param id id字段
	 * @return
	 */
	@GetMapping(value = "/queryOne/{id}")
	public User queryUserOneById(@PathVariable("id") String id) {
		User user = null;
		try {
			user = userService.queryUserOneById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * 根据id修改一条user中的记录
	 *
	 * @param user 实体类
	 */
	@PostMapping(value = "/update")
	public String updateUserById(@RequestBody User user) {
		try {
			jmsTemplate.send(updateUser, new MessageCreator() {
				@Override
				public Message createMessage(Session session) throws JMSException {
					TextMessage textMessage = session.createTextMessage(JSON.toJSONString(user));
					return textMessage;
				}
			});
			return "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "修改失败";
		}
	}

	/**
	 * 向user表中添加一条记录
	 *
	 * @param user
	 */
	@PutMapping(value = "inset")
	public String insertUser(User user) {
		try {
			userService.insertUser(user);
			return "添加成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "添加失败";
		}
	}

	/**
	 * 删除user表中所有记录
	 */
	@DeleteMapping(value = "delete")
	public String deleteUserAll() {
		try {
			userService.deleteUserAll();
			return "删除成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "删除失败";
		}

	}

	/**
	 * 删除一条记录
	 *
	 * @param id
	 */
	@DeleteMapping(value = "delete/{id}")
	public String deleteUserOneById(@PathVariable("id") String id) {
		try {
			userService.deleteUserOneById(id);
			return "删除成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "删除失败";
		}
	}
}
