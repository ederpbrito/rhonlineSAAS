package br.com.rhonline.multitenant;

import static br.com.rhonline.multitenant.MultiTenantConstants.CURRENT_TENANT_IDENTIFIER;
import static br.com.rhonline.multitenant.MultiTenantConstants.DEFAULT_TENANT_ID;
import static br.com.rhonline.multitenant.MultiTenantConstants.TENANT_KEY;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class MultiTenantFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) servletRequest;

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (req.getHeader(TENANT_KEY) != null) {
			req.setAttribute(CURRENT_TENANT_IDENTIFIER, req.getHeader(TENANT_KEY));
		} else {
			if (auth.getName().equals("João")) {
				req.setAttribute(CURRENT_TENANT_IDENTIFIER, 1);
			} else if (auth.getName().equals("Maria")) {
				req.setAttribute(CURRENT_TENANT_IDENTIFIER, 2);
			} else if (auth.getName().equals("Luiz")) {
				req.setAttribute(CURRENT_TENANT_IDENTIFIER, 3);
			} else {
				req.setAttribute(CURRENT_TENANT_IDENTIFIER, DEFAULT_TENANT_ID);
			}
		}

		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
	}
}
