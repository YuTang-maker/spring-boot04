package com.aa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author: 挥剑可以留住落樱吗
 * @create: 2021-01-05 11:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

	/**
	 * id
	 */
	private String id;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 年龄
	 */
	private Integer age;

}
