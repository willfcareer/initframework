package com.xiaomi.ebiz.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import com.xiaomi.ebiz.dao.entity.Resource;
import com.xiaomi.ebiz.dao.mapper.ResourceMapper;
import com.xiaomi.ebiz.utils.CollectionUtils;

@Component
public class DefaultSecurityMetadataSource implements FilterInvocationSecurityMetadataSource, InitializingBean {
	
	private static final Logger logger = LoggerFactory.getLogger(DefaultSecurityMetadataSource.class);

	private Map<String, Collection<ConfigAttribute>> resources = CollectionUtils.newHashMap();

	@Autowired
	private ResourceMapper resourceMapper;

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {		
		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		Collection<ConfigAttribute> attributes = resources.get(requestUrl);
		if(logger.isDebugEnabled()) logger.debug(String.format("Found configAttribute %s by requestUrl:",attributes,requestUrl));
		return attributes;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		if (Resource.class.isAssignableFrom(clazz)) return true;
		return false;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (resourceMapper == null) throw new IllegalStateException("resourceMapper can't be null");
		List<Resource> _resources = resourceMapper.findAll();
		for (Resource resource : _resources) {
			Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
			// 以权限名封装为Spring的security Object
			ConfigAttribute configAttribute = new SecurityConfig(resource.getName());
			configAttributes.add(configAttribute);
			resources.put(resource.getValue(), configAttributes);
		}
	}
}