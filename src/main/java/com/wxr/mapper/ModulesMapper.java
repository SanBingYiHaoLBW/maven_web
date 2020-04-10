package com.wxr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wxr.entity.Modules;
import com.wxr.entity.Roles;

public interface ModulesMapper {

	/*List<Modules> selectAllModules(@Param("Name") String Name,@Param("limit") int limit, @Param("page") int page);

	
	 条数
	 
	int getConutModules(@Param("Name") String Name);*/
	
	public List<Modules> getAllModules();
	   public Modules getAllModulesbyid(@Param("id")Integer id);
	   public int updateModulesById(Modules modules);
	   public int deleteModulesById(@Param("id")Integer id);
	   public int addModules(@Param("modules")Modules modules);
	
	 //页面导航栏d
		public List<Roles> getRolesByUseid(@Param("UserId")String uid);
		public List<Modules> getModuleByroleid(List<String> rid);
		
}
