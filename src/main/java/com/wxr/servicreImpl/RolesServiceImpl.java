package com.wxr.servicreImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wxr.entity.QuanXian;
import com.wxr.entity.Roles;
import com.wxr.mapper.RolesMapper;
import com.wxr.servicre.RolesService;
@Service
public class RolesServiceImpl implements RolesService {
	@Resource(name="rolesMapper")
	private  RolesMapper rolesMapper;
		
		public List<Roles> getAllModules(String Name, Integer limit, Integer page) {
			// TODO Auto-generated method stub
			return rolesMapper.selectAllRoles(Name, limit, page);
		}
		public int getConutModules(String Name) {
			// TODO Auto-generated method stub
			return  rolesMapper.getConutRoles(Name);
		}
		public int addJs(Roles r) {
			// TODO Auto-generated method stub
			return rolesMapper.addJs(r);
		}
		public int deleteJs(String Name) {
			// TODO Auto-generated method stub
			return rolesMapper.deleteJs(Name);
		}
		public int upDateJs(String Id, String Name) {
			// TODO Auto-generated method stub
			return rolesMapper.upDateJs(Id, Name);
		}
		public List<QuanXian> getLeft() {
			// TODO Auto-generated method stub
			return rolesMapper.getLeft();
		}
		public List<QuanXian> getRight(String roleId) {
			// TODO Auto-generated method stub
			return rolesMapper.getRight(roleId);
		}
		public int addrolemodules(Integer mId, String rId) {
			// TODO Auto-generated method stub
			return rolesMapper.addrolemodules(mId, rId);
		}
		public int delrolemodules(Integer mId, String rId) {
			// TODO Auto-generated method stub
			return rolesMapper.delrolemodules(mId, rId);
		}
		
		
}
