package com.wxr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wxr.entity.QuanXian;
import com.wxr.entity.Roles;

public interface RolesMapper {
	List<Roles> selectAllRoles(@Param("Name") String Name, @Param("limit") Integer limit, @Param("page") Integer page);

	/*
	 * ����
	 */
	int getConutRoles(@Param("Name") String Name);
	/*
	 * ���
	 */
	@Insert("INSERT INTO roles VALUES (#{r.Id},#{r.Name},#{r.Int0},#{r.String0})")
	int addJs(@Param("r")Roles r);

	/*
	 * ɾ��
	 */
	@Delete("delete from roles where Name = #{Name}")
	int deleteJs(@Param("Name")String Name);


	@Update("update roles set Name=#{Name} where Id=#{Id}")
	int upDateJs(@Param("Id")String Id,@Param("Name") String Name);
	
	/*
	 * ��ɫȨ����ɾ�Ĳ�
	 */
	@Select("select `Name` as title,Id as value from modules")
	List<QuanXian> getLeft();
	
	List<QuanXian> getRight(@Param("roleId")String roleId);

	int addrolemodules(@Param("mid")Integer mId, @Param("rid")String rId);
	int  delrolemodules(@Param("mid")Integer mId, @Param("rid")String rId);
}
