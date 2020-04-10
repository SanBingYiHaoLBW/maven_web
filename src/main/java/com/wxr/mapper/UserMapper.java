package com.wxr.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wxr.entity.QuanXian;
import com.wxr.entity.Roles;
import com.wxr.entity.Users;

public interface UserMapper {
	/*
	 * cha
	 */

	List<Users> selectAll(@Param("userName") String userName, @Param("beginDate") String beginDate,
			@Param("endDate") String endDate, @Param("isLock") String isLock, 
			@Param("limit") Integer limit, @Param("page") Integer page);

	/*
	 * 条数
	 */
	int getConut(@Param("userName") String userName, @Param("beginDate") String beginDate, @Param("endDate") String endDate,
			@Param("isLock") String isLock);

	/*
	 * 添加
	 */
	int add(@Param("id")String id_a,@Param("name")String name_a,@Param("pass")String pass_a,@Param("suo")String suo_a );

	/*
	 * 删除
	 */
	@Delete("delete from users where LoginName = #{LoginName}")
	int delete(String LoginName);

    /*
     * 修改
     * */
	@Update("update users set Password=#{Password} where LoginName=#{LoginName}")
	int upDateUsers(@Param("LoginName")String LoginName,@Param("Password") String Password);
	
	int suo(@Param("id")String id,@Param("onsuo")String isLock);
	
	int unsuo(@Param("id")String id,@Param("unsuo")String isLock);
	
	int ressetPass(@Param("id")String id,@Param("resetPass")String Pass);


	/*
	 * 用户角色增删改查
	 */
	List<QuanXian> getLeft();
	
	List<QuanXian> getRight(@Param("userId")String userId);

	int addUserRoles(@Param("uid")String uId, @Param("rid")String rId);
	int  delUserRole(@Param("uid")String uId, @Param("rid")String rId);
	
	/*
	 * 登录
	 */
	Users login(@Param("name")String name,@Param("pass")String pass);
	int updateLastTime(@Param("name")String name,@Param("lastLoginTime") String lastLoginTime);

	List<Roles> getRolesByUserid(@Param("uid")String uid);
}
