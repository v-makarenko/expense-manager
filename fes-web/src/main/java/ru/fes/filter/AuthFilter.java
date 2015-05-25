package ru.fes.filter;

import ru.fes.common.AppConsts;
import ru.fes.dto.user.AccessAuthDto;
import ru.fes.services.SessionService;
import ru.fes.services.TokenService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by VMakarenko on 2/10/15.
 */
public class AuthFilter implements Filter{
    @Inject
    private SessionService sessionService;
    @Inject
    private TokenService tokenService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String id = null;
        String token = null;
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        for (Cookie cookie : req.getCookies()) {
            if(cookie.getName().equals(AccessAuthDto.COOKIE_ID)){
                id = cookie.getValue();
            }
            if(cookie.getName().equals(AccessAuthDto.COOKIE_TOKEN)){
                token = cookie.getValue();
            }
        }
        if(token != null && id != null && tokenService.checkEntry(id, token)){
            sessionService.setUserId(UUID.fromString(id));
            filterChain.doFilter(servletRequest, servletResponse);
        } else{
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
        }

    }

    @Override
    public void destroy() {

    }
}
