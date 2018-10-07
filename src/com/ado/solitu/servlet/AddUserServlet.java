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
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
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
		Writer writer=response.getWriter();
		
		String name=request.getParameter("uname");
		String password=request.getParameter("password");
		String gender=request.getParameter("ugender");
		int age=Integer.valueOf(request.getParameter("uage"));;
		String phone=request.getParameter("uphone");
		String address=request.getParameter("uaddress");
		String auth=request.getParameter("uauth");
		
		UserBean userBean=new UserBean();
		userBean.setU_id(0);
		userBean.setU_name(name);
		userBean.setU_password(password);
		userBean.setU_gender(gender);
		userBean.setU_age(age);
		userBean.setU_phone(phone);
		userBean.setU_address(address);
		userBean.setU_auth(auth);
		
		UserService userservice=(UserService) ObjectFactory.getObject("UserService");
		try {
			userservice.addUser(userBean);
			writer.write("<script type='text/javascript'>alert('添加成功,返回用户管理界面...');location.href='./jsp/usermanager.jsp';</script>");
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

}
