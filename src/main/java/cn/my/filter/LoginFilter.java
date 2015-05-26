package cn.my.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;  
		HttpSession session = request.getSession();  
        // 如果session不为空，则可以浏览其他页面  
        String url = request.getServletPath();  
        System.out.println(url);  
        
      /*  if ((!request.getServletPath().equals("/login"))  
                && (!request.getServletPath().equals("/login.jsp"))  
                && (!request.getServletPath().equals("/relogin.jsp"))  
                && (!request.getServletPath().equals("/jquery-1.8.0.min.js"))) {
        	
        	  if (session.getAttribute("userInfo") == null) {
              	session.invalidate();
              	 response.setContentType("text/html;charset=gb2312");  
                   PrintWriter out = response.getWriter();  
                   out.println("<script language='javascript' type='text/javascript'>");  
                   out.println("alert('由于你长时间没有操作,导致Session失效!请你重新登录!');");  //window.location.href='" + request.getContextPath() + "/aa/init'
                   out.println("</script>");  
              }
        	
        }*/
      
        
        chain.doFilter(request, response);  
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
