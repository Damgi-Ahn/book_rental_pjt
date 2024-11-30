package com.office.library.bookrentalpjt.user.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;

public class UserMemberLoginInterceptor extends WebRequestHandlerInterceptorAdapter {

    public UserMemberLoginInterceptor(WebRequestInterceptor requestInterceptor) {
        super(requestInterceptor);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        HttpSession session = request.getSession(false);
        if (session != null) {
            Object object = session.getAttribute("loginedUserMemberVo");

            if (object != null)
                return true;

        }

        response.sendRedirect(request.getContextPath() + "/user/member/loginForm");

        return false;

    }

}
