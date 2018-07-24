package com.sinux.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UserInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// 得到请求的url
		String url = request.getRequestURI();
		// 判断是不是登录的请求
		System.out.println("url=" + url);

		// 获取Session 如果为空拦截
		String session = (String) request.getSession().getAttribute("usercode");
		// 判断是否为空
		if (session != null) {
			return true;
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		// response.sendRedirect(request.getContextPath() + "/user/login");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
