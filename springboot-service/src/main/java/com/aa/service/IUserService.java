package com.aa.service;

import com.aa.entity.User;

import java.util.List;

/**
 * @author: 挥剑可以留住落樱吗
 * @create: 2021-01-05 16:08
 */
public interface IUserService {

	/**
	 * 查询user表所有记录
	 *
	 * @return
	 */
	List<User> queryUserAll();

	/**
	 * 根据id查询user表中一条记录
	 *
	 * @param id id字段
	 * @return
	 */
	User queryUserOneById(String id);

	/**
	 * 根据id修改user表中一条记录
	 *
	 * @param user 实体类
	 */
	void updateUserById(User user);

	/**
	 * 向user表中添加一条记录
	 *
	 * @param user
	 */
	void insertUser(User user);

	/**
	 * 删除user中所有记录
	 */
	void deleteUserAll();

	/**
	 * 根据id删除user表中一条记录
	 *
	 * @param id
	 */
	void deleteUserOneById(String id);
}
