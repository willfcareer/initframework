package com.xiaomi.ebiz.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xiaomi.ebiz.dao.entity.Message;

public interface MessageMapper {
	@Select("SELECT * FROM message WHERE id = #{id}")
	public List<Message> findMessage(@Param("id") final int id);
}
