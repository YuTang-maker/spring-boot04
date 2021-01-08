package com.aa.dao;

import com.aa.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: 挥剑可以留住落樱吗
 * @create: 2021-01-05 11:35
 */
@Mapper
public interface UserDao {

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
	List<User> queryUserOneById(String id);

	/**
	 * 根据id修改user表中一条记录
	 *
	 * @param user 实体类
	 * @return
	 */
	int updateUserById(User user);

	/**
	 * 向user表中添加一条记录
	 *
	 * @param user
	 * @return
	 */
	int insertUser(User user);

	/**
	 * 删除user中所有记录
	 *
	 * @return
	 */
	int deleteUserAll();

	/**
	 * 根据id删除user表中一条记录
	 *
	 * @param id
	 * @return
	 */
	int deleteUserOneById(String id);

}
