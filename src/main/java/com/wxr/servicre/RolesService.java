package com.wxr.servicre;

import java.util.List;

import com.wxr.entity.QuanXian;
import com.wxr.entity.Roles;

public interface RolesService {
  
	public List<Roles> getAllModules(String Name,Integer limit,Integer page);
	/*
	 * ����
	 * */
		int getConutModules(String Name);
		
		/*
		 * ����
		 */
		int addJs(Roles r);

		/*
		 * ɾ��
		 */
		int deleteJs(String Name);

		/*
		 * �޸�
		 * */
		int upDateJs(String Id,String Name);

		/*
		 * ��ɫȨ����ɾ�Ĳ�
		 */
		
		List<QuanXian> getLeft();
		List<QuanXian> getRight(String roleId);

		int addrolemodules(Integer mId, String rId);
		int  delrolemodules(Integer mId, String rId);
}
