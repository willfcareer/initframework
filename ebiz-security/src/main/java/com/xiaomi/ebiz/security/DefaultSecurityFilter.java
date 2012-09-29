package com.xiaomi.ebiz.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

public class DefaultSecurityFilter extends AbstractSecurityInterceptor implements Filter {
	// 与context-security.xml里的myFilter的属性securityMetadataSource对应，
	// 其他的两个组件，已经在AbstractSecurityInterceptor定义
	private FilterInvocationSecurityMetadataSource securityMetadataSource;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		FilterInvocation invocation = new FilterInvocation(request, response, chain);
		// object为FilterInvocation对象
		// 1.获取请求资源的权限
		// 执行Collection<ConfigAttribute> attributes =
		// SecurityMetadataSource.getAttributes(object);
		// 2.是否拥有权限
		// 获取安全主体，可以强制转换为UserDetails的实例
		// 1) UserDetails
		// Authentication authenticated = authenticateIfRequired();
		// this.accessDecisionManager.decide(authenticated, object, attributes);
		// 用户拥有的权限
		// 2) GrantedAuthority
		// Collection<GrantedAuthority> authenticated.getAuthorities()
		System.out.println("用户发送请求！ ");
		InterceptorStatusToken token = null;
		token = super.beforeInvocation(invocation);
		try {
			invocation.getChain().doFilter(invocation.getRequest(), invocation.getResponse());
		} finally {
			super.afterInvocation(token, null);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

	@Override
	public Class<?> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return securityMetadataSource;
	}

	@Override
	public void destroy() {

	}
	
	public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
		return securityMetadataSource;
	}

	public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource securityMetadataSource) {
		this.securityMetadataSource = securityMetadataSource;
	}
}
