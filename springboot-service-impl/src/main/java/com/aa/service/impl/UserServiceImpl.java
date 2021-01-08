package com.aa.service.impl;

import cn.hutool.core.lang.UUID;
import com.aa.dao.UserDao;
import com.aa.entity.User;
import com.aa.service.IUserService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: 挥剑可以留住落樱吗
 * @create: 2021-01-05 16:20
 */

@Service
public class UserServiceImpl implements IUserService {

	@Resource
	private UserDao userDao;

	/**
	 * 查询user表中所有记录
	 *
	 * @return
	 */
	@Override
	public List<User> queryUserAll() {
		return userDao.queryUserAll();
	}

	/**
	 * 根据id字段查找一条user表中一条记录
	 *
	 * @param id id字段
	 * @return
	 */
	@Override
	public User queryUserOneById(String id) {

		if (id == null || StringUtils.isEmpty(id)) {
			throw new RuntimeException("参数异常");
		}

		List<User> users = userDao.queryUserOneById(id);

		if (users == null || users.size() == 0) {
			throw new RuntimeException("没有此条记录");
		}

		if (users.size() > 1) {
			throw new RuntimeException("数据库数据异常");
		}

		return users.get(0);
	}

	/**
	 * 根基id修改一条user中的记录
	 *
	 * @param user 实体类
	 */
	@Override
	public void updateUserById(User user) {
		if (user == null || StringUtils.isEmpty(user.getId())) {
			throw new RuntimeException("参数异常");
		}

		int result = userDao.updateUserById(user);

		if (result < 1) {
			throw new RuntimeException("修改失败");
		}

	}

	/**
	 * 向user表中添加一条记录
	 *
	 * @param user
	 */
	@Override
	public void insertUser(User user) {
		if (user == null) {
			throw new RuntimeException("参数异常");
		}

		user.setId(UUID.randomUUID() + "");

		int result = userDao.insertUser(user);

		if (result < 1) {
			throw new RuntimeException("修改失败");
		}
	}

	/**
	 * 删除user表中所有记录
	 */
	@Override
	public void deleteUserAll() {
		int result = userDao.deleteUserAll();
		if (result < 1) {
			throw new RuntimeException("全部删除失败");
		}
	}

	/**
	 * 删除一条记录
	 *
	 * @param id
	 */
	@Override
	public void deleteUserOneById(String id) {

		if (id == null || StringUtils.isEmpty(id)) {
			throw new RuntimeException("参数异常");
		}

		int result = userDao.deleteUserOneById(id);

		if (result < 1) {
			throw new RuntimeException("删除失败");
		}
	}
}
