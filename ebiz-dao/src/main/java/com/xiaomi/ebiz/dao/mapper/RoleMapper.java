package com.xiaomi.ebiz.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.xiaomi.ebiz.dao.entity.Role;

public interface RoleMapper {
	@Select("SELECT * FROM role")
	public List<Role> findAll();
}
