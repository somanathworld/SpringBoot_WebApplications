package com.nt.interceptor;

import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class TimeOutCheckInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		System.out.println("TimeOutCheckInterceptor.preHandle()");
		LocalDateTime ldt = LocalDateTime.now();
		int hours = ldt.getHour();
		if(hours<12 || hours>18) {
			RequestDispatcher rd = req.getRequestDispatcher("/timeout.jsp");
			rd.forward(req, res);
			return false;
		}
		return true;
	}
}
