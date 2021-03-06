package com.miui.sec.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.miui.sec.dao.entity.User;

public interface UserMapper {

	@Select("SELECT * FROM user WHERE username = #{username}")
	public List<User> findByName(@Param("username") final String username);

}
