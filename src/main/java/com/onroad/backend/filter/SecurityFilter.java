package com.onroad.backend.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName = "SecurityFilter", value="/*")
@Component
public class SecurityFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        System.out.println("caiu!");

        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        String permissao = (String) session.getAttribute("permissao");

        // adm
//        if (permissao != null && !(permissao == "adm")) {
//            response.sendError(HttpServletResponse.SC_FORBIDDEN);
//            // acesso negado = codigo 403
//        }
        if (user == null)
        {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
