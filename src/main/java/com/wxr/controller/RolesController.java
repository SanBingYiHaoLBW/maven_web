package com.wxr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wxr.entity.QuanXian;
import com.wxr.entity.Roles;
import com.wxr.servicre.RolesService;
import com.wxr.util.Result;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@RestController
@Transactional
public class RolesController {
	@Resource(name = "rolesServiceImpl")
	private RolesService rolesServiceImpl;

	@RequestMapping("/getRoles")
	@ResponseBody
	public String getRoles(String Name, Integer limit, Integer page) {
		int page1 = (page - 1) * limit;
		System.out.println(Name + "," + limit + "," + page);
		List<Roles> r = rolesServiceImpl.getAllModules(Name, limit, page1);
		int count = rolesServiceImpl.getConutModules(Name);
		String dd = Result.toClient("0", "", count, r);
		return dd;
	}

	@RequestMapping("/goro")
	public String go1() {
		return "Roles";
	}
	
	/*
	 * 添加
	 */
	@PostMapping("/addJs")
	@ResponseBody
	public String addJs(Roles r) {
		int a =rolesServiceImpl.addJs(r);
		String dd=null;
		if(a!=0) {
		 dd = Result.toClient("0","添加成功");
		}else {
		 dd = Result.toClient("1","添加失败");	
		}
		return dd;
	}


	/*
	 * 删除
	 */
	@PostMapping("/deleteJs")
	@ResponseBody
	public Map<String, Object> deleteJs(String Name) {
		Map<String, Object> map=new HashMap<String, Object>();
		int n=rolesServiceImpl.deleteJs(Name);
		if(n>0) {
			map.put("code", 0);
			return map;
		}
		return null;
	}
	/*
	 * 修改
	 */
	@PostMapping("/upDateJs")
	@ResponseBody
	public Map<String, Object> upDateJs(String Id, String Name) {
		Map<String, Object> map=new HashMap<String, Object>();
		int n=rolesServiceImpl.upDateJs(Id, Name);
		if(n>0) {
			map.put("code", 0);
			return map;
		}
		return null;
	}
	/*
	 * 获得穿梭框左侧
	 */
	@PostMapping("/getrolemodulesLeft")
	    public List<QuanXian> getrolemodulesLeft() {
		List<QuanXian> qx =  rolesServiceImpl.getLeft();
		return qx;

	}
	/*
	 * 获得穿梭框右侧
	 */
	@RequestMapping("/getrolemodulesRightByid")
	public  List<QuanXian> getrolemodulesRightByid(String RoleId) {
		
		  List<QuanXian> qx =  rolesServiceImpl.getRight(RoleId);
		 
	return qx;
	}
	/*
	 * 用户添加角色
	 **/
	@RequestMapping("/addrolemodules")
	public List<Object> addrolemodules(Integer mId,String rId) {
	
		rolesServiceImpl.addrolemodules(mId, rId);
			return null;
	}
	/*
	 * 用户删除角色
	 **/
	@RequestMapping("/delrolemodules")
	public List<Object> delrolemodules(Integer mId1,String rId1) {
		rolesServiceImpl.delrolemodules(mId1, rId1);
			return null;
	}
}
