package com.kh.test.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		// POST 방식 문제점 : 문자 인코딩 불일치(한글 깨짐)
		req.setCharacterEncoding("UTF-8");

		// Parameter(매개 변수 == 전달 받아온 값)
		
		String black = req.getParameter("blackPen"); 
		String red = req.getParameter("redPen"); 
		String blue = req.getParameter("bluePen"); 
		String white = req.getParameter("white"); 
		
		int total = Integer.parseInt(black)*500+Integer.parseInt(red)*700+Integer.parseInt(blue)*700+Integer.parseInt(white)*1000;
		int iblack = Integer.parseInt(black)*500;
		int ired = Integer.parseInt(red)*700;
		int iblue = Integer.parseInt(blue)*700;
		int iwhite = Integer.parseInt(white)*1000 ;
		req.setAttribute("black", iblack);
		req.setAttribute("red", ired);
		req.setAttribute("blue", iblue);
		req.setAttribute("white", iwhite);
		req.setAttribute("total", total);
		
		if(total>0) {
			RequestDispatcher dispatcher
				= req.getRequestDispatcher("/WEB-INF/views/resultPage.jsp");
		
			// 요청 위임
			dispatcher.forward(req, resp);
		}else {
			RequestDispatcher dispatcher
			= req.getRequestDispatcher("/WEB-INF/views/errorPage.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
	
}
