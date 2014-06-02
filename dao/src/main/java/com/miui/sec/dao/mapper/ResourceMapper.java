package com.miui.sec.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.miui.sec.dao.entity.Resource;

public interface ResourceMapper {

	@Select("SELECT * FROM resource")
	public List<Resource> findAll();

	@Select("SELECT * FROM resource WHERE id IN (SELECT resource_id FROM role_resource WHERE role_id = #{rid})")
	public List<Resource> findResourcesByRid(@Param("rid") final int rid);
}
