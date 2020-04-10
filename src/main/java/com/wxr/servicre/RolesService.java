package com.wxr.servicre;

import java.util.List;

import com.wxr.entity.QuanXian;
import com.wxr.entity.Roles;

public interface RolesService {
  
	public List<Roles> getAllModules(String Name,Integer limit,Integer page);
	/*
	 * 条数
	 * */
		int getConutModules(String Name);
		
		/*
		 * 增加
		 */
		int addJs(Roles r);

		/*
		 * 删除
		 */
		int deleteJs(String Name);

		/*
		 * 修改
		 * */
		int upDateJs(String Id,String Name);

		/*
		 * 角色权限增删改查
		 */
		
		List<QuanXian> getLeft();
		List<QuanXian> getRight(String roleId);

		int addrolemodules(Integer mId, String rId);
		int  delrolemodules(Integer mId, String rId);
}
