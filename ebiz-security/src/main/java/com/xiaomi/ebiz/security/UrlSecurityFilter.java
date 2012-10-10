package com.xiaomi.ebiz.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

public class UrlSecurityFilter extends AbstractSecurityInterceptor implements Filter {

	@Autowired
	private FilterInvocationSecurityMetadataSource securityMetadataSource;

	@SuppressWarnings("unused")
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		StringBuffer url = request.getRequestURL();
		FilterInvocation invocation = new FilterInvocation(servletRequest, servletResponse, chain);
		// // 1.获取请求资源的权限
		// Collection<ConfigAttribute> attributes =
		// securityMetadataSource.getAttributes(invocation);
		// // 2.是否拥有权限
		// // 获取安全主体，可以强制转换为UserDetails的实例
		// // 1) UserDetails
		// Authentication authenticated = authenticateIfRequired();
		// this.
		// getAccessDecisionManager().decide(authenticated, invocation,
		// attributes);
		// // 用户拥有的权限
		// // 2) GrantedAuthority
		// // Collection<GrantedAuthority> authenticated.getAuthorities()
		InterceptorStatusToken token = null;
		token = super.beforeInvocation(invocation);
		try {
			invocation.getChain().doFilter(invocation.getRequest(), invocation.getResponse());
		} finally {
			super.afterInvocation(token, null);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	@Override
	public void destroy() {

	}

	@Override
	public Class<?> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return securityMetadataSource;
	}

}
