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
	 * ����
	 */
	int getConut(String userName, String beginDate, String endDate, String isLock);

	/*
	 * ����
	 */
	int addUser(String id_a,String name_a,String pass_a,String suo_a);

	/*
	 * ɾ��
	 */
	int deleteUsers(String LoginName);

	/*
	 * �޸�
	 * */
	int upDateUsers(String LoginName,String Password);
	int suo(String id,String isLock);
	int unsuo(String id,String isLock);
	int ressetPass(String id,String Pass);
	
	/*
	 * �����û�id���ɫ��
	 */
	public List<QuanXian> getLeft();
	
	List<QuanXian> getRight(String userId);
	/*
	 * ����û���ɫ
	 */
	public int addUserRoles(String uId,String rId);
	
	public int delUserRole(String uId,String rId);
	/*	  
	 * ����name���û�
	 * ����name�޸�����¼ʱ��
	 */
	Users login(String name,String pass);
	int updateLastTime(String name, String lastLoginTime);

	public List<Roles> getRolesByid(String uid);

	public List<String> getrname(List<Roles> rs);
}
