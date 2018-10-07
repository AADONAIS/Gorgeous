package com.ado.solitu.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ado.solitu.entity.UserBean;
import com.ado.solitu.exception.MyException;
import com.ado.solitu.object.factory.ObjectFactory;
import com.ado.solitu.service.UserService;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Writer out=response.getWriter();
		
		String name=request.getParameter("uname");
		int age=Integer.valueOf(request.getParameter("uage"));
		String address=request.getParameter("uaddress");
		int id=Integer.valueOf(request.getParameter("userId"));
		UserBean userBean=new UserBean();
		userBean.setU_name(name);
		userBean.setU_age(age);
		userBean.setU_address(address);
		
		UserService userservice=(UserService)ObjectFactory.getObject("UserService");
		try {
			userservice.updateUser(userBean, id);;
			out.write("<script type='text/javascript'>alert('ÐÞ¸Ä³É¹¦');location.href='./jsp/usermanager.jsp';</script>");
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

}
