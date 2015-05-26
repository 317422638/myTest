package cn.my.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UserInjectInterceptor extends HandlerInterceptorAdapter {
	
	@Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
       /* if (handler.isAssignableFrom(IUserAware)){
        User user = (User)httpServletRequest.getSession().getAttribute("currentUser");
        IUserAware userAware = (IUserAware) handler;
        userAware.setUser(user);
        }*/
		System.out.println("-------==========----------");
        return super.preHandle(httpServletRequest, httpServletResponse, handler);
    }
}
