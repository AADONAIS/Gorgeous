package com.ado.solitu.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
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
		Writer write=response.getWriter();
		String name=request.getParameter("username");
		String password=request.getParameter("userpwd");

		UserService userservice=(UserService) ObjectFactory.getObject("UserService");
		List<UserBean> userlist=new ArrayList<UserBean>();
		try {
			userlist=userservice.login();
			for (UserBean userBean : userlist) {
				if(name.equals(userBean.getU_name()) && password.equals(userBean.getU_password())) {
					write.write("<script>alert('登录成功,正在跳转页面...');location.href='./jsp/welcome.jsp';</script>");
				}else if(!name.equals(userBean.getU_name()) && !password.equals(userBean.getU_password())){
					write.write("<script>alert('用户名或密码错误');location.href='${pageContext.request.contextPath}/jsp/login.jsp';</script>");
					return;
				}else if((name==null||name.equals(""))||(password==null||password.equals(""))) {
					write.write("<script>alert('用户名或密码为空');location.href='${pageContext.request.contextPath}/jsp/login.jsp';</script>");
					return;
				}
			}
		} catch (MyException e) {
			e.printStackTrace();
		}
		
	}

}
