package com.wxr.servicre;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxr.entity.QuanXian;
import com.wxr.entity.Roles;
import com.wxr.entity.Users;

public interface UserService {

	public List<Users> getAll(String userName, String beginDate, String endDate, String isLock, Integer limit, Integer page);

	/*
	 * 条数
	 */
	int getConut(String userName, String beginDate, String endDate, String isLock);

	/*
	 * 增加
	 */
	int addUser(String id_a,String name_a,String pass_a,String suo_a);

	/*
	 * 删除
	 */
	int deleteUsers(String LoginName);

	/*
	 * 修改
	 * */
	int upDateUsers(String LoginName,String Password);
	int suo(String id,String isLock);
	int unsuo(String id,String isLock);
	int ressetPass(String id,String Pass);
	
	/*
	 * 根据用户id查角色名
	 */
	public List<QuanXian> getLeft();
	
	List<QuanXian> getRight(String userId);
	/*
	 * 添加用户角色
	 */
	public int addUserRoles(String uId,String rId);
	
	public int delUserRole(String uId,String rId);
	/*	  
	 * 根据name查用户
	 * 根据name修改最后登录时间
	 */
	Users login(String name,String pass);
	int updateLastTime(String name, String lastLoginTime);

	public List<Roles> getRolesByid(String uid);

	public List<String> getrname(List<Roles> rs);
}
