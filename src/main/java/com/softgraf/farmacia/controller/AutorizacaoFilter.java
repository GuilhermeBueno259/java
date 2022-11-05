package com.softgraf.farmacia.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("*.xhtml")
public class AutorizacaoFilter implements Filter {

	@Inject
	private Usuario usuario;

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		if (!usuario.isLogado() && !request.getRequestURI().endsWith("/login.xhtml")
				&& !request.getRequestURI().contains("/javax.faces.resource/")) {

			// redireciona
			response.sendRedirect(request.getContextPath() + "/login.xhtml");
		} else {
			// quando já está logado, chama o recurso
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
