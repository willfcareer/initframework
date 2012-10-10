package com.xiaomi.ebiz.dao.entity;

import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import com.xiaomi.ebiz.utils.CollectionUtils;

@Entity
public class Role {
	private Integer id;
	private Integer enable;
	private String name;
	private Set<Resource> resources = CollectionUtils.newHashSet();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEnable() {
		return enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Resource> getResources() {
		return resources;
	}

	public void addResources(List<Resource> resources) {
		this.resources.addAll(resources);
	}
}
