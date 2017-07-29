package com.kwh.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kwh.common.TreeNode;
import com.kwh.constants.UserConstants;
import com.kwh.entity.User;
import com.kwh.service.ResourceService;

public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private ResourceService resourceService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        Object sessionUser = session.getAttribute(UserConstants.SESSION_USER);
        if (sessionUser == null) {
            response.sendRedirect(
                    request.getContextPath() + "/login?target=" + request.getRequestURI().replaceFirst("/smmr", ""));
            return false;
        }
        if (sessionUser instanceof User) {
            User user = (User) sessionUser;
            List<TreeNode> treeNodes = resourceService.getMenu(user, true);
            for (TreeNode treeNode : treeNodes) {
                if (request.getRequestURI().equals(treeNode.getUrl()))
                    return true;
            }
        }
        response.sendRedirect(request.getContextPath() + "/nopermission");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}
