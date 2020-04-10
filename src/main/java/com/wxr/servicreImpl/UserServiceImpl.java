package com.wxr.servicreImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wxr.entity.QuanXian;
import com.wxr.entity.Roles;
import com.wxr.entity.Users;
import com.wxr.mapper.UserMapper;
import com.wxr.servicre.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource(name = "userMapper")
	private UserMapper userMapper;

	public List<Users> getAll(String userName, String beginDate, String endDate, String isLock, Integer limit,
			Integer page) {
		// TODO Auto-generated method stub
		return userMapper.selectAll(userName, beginDate, endDate, isLock, limit, page);
	}

	public int getConut(String userName, String beginDate, String endDate, String isLock) {
		// TODO Auto-generated method stub
		return userMapper.getConut(userName, beginDate, endDate, isLock);
	}

	/*
	 * Ìí¼Ó
	 */
	public int addUser(String id_a, String name_a, String pass_a, String suo_a) {
		// TODO Auto-generated method stub

		return userMapper.add(id_a, name_a, pass_a, suo_a);
	}

	public int deleteUsers(String LoginName) {
		// TODO Auto-generated method stub
		return userMapper.delete(LoginName);
	}

	public int upDateUsers(String LoginName, String Password) {
		// TODO Auto-generated method stub
		return userMapper.upDateUsers(LoginName, Password);
	}

	public Users login(String name, String pass) {
		// TODO Auto-generated method stub
		return userMapper.login(name, pass);
	}

	public List<QuanXian> getLeft() {
		// TODO Auto-generated method stub
		return userMapper.getLeft();
	}

	public List<QuanXian> getRight(String userId) {
		// TODO Auto-generated method stub
		return userMapper.getRight(userId);
	}

	public int addUserRoles(String uId, String rId) {
		// TODO Auto-generated method stub
		return userMapper.addUserRoles(uId, rId);
	}

	public int delUserRole(String uId, String rId) {
		// TODO Auto-generated method stub
		return userMapper.delUserRole(uId, rId);
	}

	public int suo(String id, String isLock) {
		// TODO Auto-generated method stub
		return userMapper.suo(id, isLock);
	}

	public int unsuo(String id, String isLock) {
		// TODO Auto-generated method stub
		return userMapper.unsuo(id, isLock);
	}

	public int ressetPass(String id, String Pass) {
		// TODO Auto-generated method stub
		return userMapper.ressetPass(id, Pass);
	}

	public int updateLastTime(String name, String lastLoginTime) {
		// TODO Auto-generated method stub
		return userMapper.updateLastTime(name, lastLoginTime);
	}

	public List<Roles> getRolesByid(String uid) {
		// TODO Auto-generated method stub
		return userMapper.getRolesByUserid(uid);
	}

	public List<String> getrname(List<Roles> rs) {
		List<String> ls= new ArrayList<String>();
		for (int i = 0; i < rs.size(); i++) {
			ls.add(rs.get(i).getName());
		}
		return ls;
	}

}
