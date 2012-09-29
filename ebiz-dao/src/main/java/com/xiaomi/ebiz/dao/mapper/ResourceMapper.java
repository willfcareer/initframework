package com.xiaomi.ebiz.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.xiaomi.ebiz.dao.entity.Resource;

public interface ResourceMapper {
	
	@Select("SELECT * FROM resource")
	public List<Resource> findAll();
}
