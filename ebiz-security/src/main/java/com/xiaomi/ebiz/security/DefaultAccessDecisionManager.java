package com.xiaomi.ebiz.security;

import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class DefaultAccessDecisionManager implements AccessDecisionManager {
	private static final Logger logger = LoggerFactory.getLogger(DefaultAccessDecisionManager.class);

	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
		if (configAttributes == null) {
			logger.debug("configAttributes is null");
			return;
		}
		// The needed authority for target resources
		Iterator<ConfigAttribute> iterator = configAttributes.iterator();
		while (iterator.hasNext()) {
			ConfigAttribute configAttribute = iterator.next();
			String authority = configAttribute.getAttribute();
			logger.debug(String.format("Needed authority: %s", authority));
			// Match authority
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				if (authority.equals(ga.getAuthority())) {
					logger.debug(String.format("Found match authority", authority));
					return;
				}
			}
		}
		throw new AccessDeniedException("Forbidden!");
	}

	@Override
	public boolean supports(ConfigAttribute arg0) {
		return true;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
