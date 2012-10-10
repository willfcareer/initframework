package com.xiaomi.ebiz.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xiaomi.ebiz.dao.entity.Role;

public interface RoleMapper {

	@Select("SELECT * FROM role")
	public List<Role> findAll();

	@Select("SELECT * FROM role WHERE id IN (SELECT role_id FROM user_role WHERE user_id = #{uid})")
	public List<Role> findRolesByUid(@Param("uid") final int uid);
}
