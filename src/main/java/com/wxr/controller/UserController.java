package com.wxr.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wxr.entity.QuanXian;
import com.wxr.entity.Roles;
import com.wxr.entity.Users;
import com.wxr.servicre.UserService;
import com.wxr.util.RedisService;
import com.wxr.util.Result;

@RestController
@Transactional
public class UserController {

	@Resource(name = "userServiceImpl")
	private UserService userServiceImpl;
	@Resource(name = "redisService")
	private RedisService redisService;

	@RequestMapping("/go")
	public String go1() {
		return "Users";
	}
	/*
	 * 查询
	 */

	@RequestMapping("/getAll")
	@ResponseBody
	public String getAll(String userName, String beginDate, String endDate, String isLock, Integer limit,
			Integer page) {
		int page1 = (page - 1) * limit;
		List<Users> u = userServiceImpl.getAll(userName, beginDate, endDate, isLock, limit, page1);
		int count = userServiceImpl.getConut(userName, beginDate, endDate, isLock);
		String dd = Result.toClient("0", "", count, u);
		return dd;
	}

	/*
	 * 添加
	 */
	@PostMapping("/addUser")
	public String addU(String id_a, String name_a, String pass_a, String suo_a) {
		int a = userServiceImpl.addUser(id_a, name_a, pass_a, suo_a);
		String dd = null;
		if (a != 0) {
			dd = Result.toClient("0", "添加成功");
		} else {
			dd = Result.toClient("1", "添加失败");
		}
		return dd;
	}

	/*
	 * 删除
	 */
	@PostMapping("/deleteUsers")
	public Map<String, Object> delete(String LoginName) {
		Map<String, Object> map = new HashMap<String, Object>();
		int n = userServiceImpl.deleteUsers(LoginName);
		if (n > 0) {
			map.put("code", 0);
			return map;
		}
		return null;
	}

	/*
	 * 修改
	 */
	@PostMapping("/upDateUsers")
	public Map<String, Object> upDateUsers(String LoginName, String Password) {
		Map<String, Object> map = new HashMap<String, Object>();
		int n = userServiceImpl.upDateUsers(LoginName, Password);
		if (n > 0) {
			map.put("code", 0);
			return map;
		}
		return null;
	}

	/*
	 * 上锁
	 */
	@RequestMapping("/suo")
	public String a(String id) {
		String isLock = "是";
		int a = userServiceImpl.suo(id, isLock);
		String dd = null;
		if (a != 0) {
			dd = Result.toClient("0", "上锁成功");
		} else {
			dd = Result.toClient("1", "上锁失败");
		}
		return dd;
	}

	/*
	 * 解锁
	 */
	@RequestMapping("/unsuo")
	public String b(String id) {
		String isLock = "否";
		int a = userServiceImpl.unsuo(id, isLock);
		String dd = null;
		if (a != 0) {
			dd = Result.toClient("0", "解锁成功");
		} else {
			dd = Result.toClient("1", "解锁失败");
		}
		return dd;
	}

	/*
	 * 重置密码
	 */
	@RequestMapping("/pass")
	public String c(String id) {
		String Pass = "ysd123";
		int a = userServiceImpl.ressetPass(id, Pass);
		String dd = null;
		if (a != 0) {
			dd = Result.toClient("0", "重置成功");
		} else {
			dd = Result.toClient("1", "重置失败");
		}
		return dd;
	}

	/*
	 * 获得穿梭框左侧
	 */
	@RequestMapping("/getUserRolesLeft")
	public List<QuanXian> getUserRolesLeft() {
		List<QuanXian> qx = userServiceImpl.getLeft();
		return qx;

	}

	/*
	 * 获得穿梭框右侧
	 */
	@RequestMapping("/getUserRolesRightByid")
	public List<QuanXian> getUserRolesRightByid(String UserId) {

		List<QuanXian> qx = userServiceImpl.getRight(UserId);

		return qx;
	}

	/*
	 * 用户添加角色
	 **/
	@RequestMapping("/addUserRoles")
	public List<Object> addUserRoles(String uId, String rId) {

		userServiceImpl.addUserRoles(uId, rId);
		return null;
	}

	/*
	 * 用户删除角色
	 **/
	@RequestMapping("/delUserRoles")
	public List<Object> delUserRoles(String uId1, String rId1) {
		userServiceImpl.delUserRole(uId1, rId1);
		return null;
	}
	/*
	 * 登录
	 */
	@PostMapping("/login")
	public Map<String, Object> login(String LoginName, String PassWord) {
		Users u = userServiceImpl.login(LoginName, PassWord);
		Map<String, Object> resultmap = new HashMap<String, Object>();
		Map<String, Object> msgmap = new HashMap<String, Object>();
		if (u != null) {
			if (u.getPassword().equals(PassWord)) {
				// 密码正确
				if (u.getIsLockout().equals("是")) {// 密码锁定
					resultmap.put("msg", "账号被锁定,请解锁");
				} else {
					// 密码没锁定更新登录时间
					SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String LastLoginTime = dft.format(new Date());
					userServiceImpl.updateLastTime(LoginName, LastLoginTime);
					String uid = u.getId();
					List<Roles> rs = userServiceImpl.getRolesByid(uid);
					List<String> rname = userServiceImpl.getrname(rs);
					System.out.println(rname);
					msgmap.put("rname", rname);
					msgmap.put("uid", uid);
					resultmap.put("code", 0);
					resultmap.put("u", u);
					resultmap.put("msg", msgmap);
					redisService.set("dd", "ddd");
					redisService.set("rname", rname);
					redisService.set("uid", uid);
				}
			}
		} else {
			resultmap.put("code", 1);
			resultmap.put("msg", "用户或密码错误");
		}
		return resultmap;
	}
}
