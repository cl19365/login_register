package com.csist.servlets;

import com.csist.po.Applicant;
import com.csist.service.ServiceCl;
import com.csist.service.impl.ServiceClImpl;
import com.csist.util.Md5Encrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class login
 */
@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String phone = request.getParameter("uname");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();

		ServiceCl service=new ServiceClImpl();
		Applicant applicant = service.login(phone, Md5Encrypt.md5(password));
		if (applicant != null) {
			// 登陆成功，则保存用户数据到session回话中
			session.setAttribute("applicant", applicant);

			response.getWriter().println("<script language='javascript'>alert('登录成功');window.location.href=' html/ReviewProcess.html';</script>");
			// 跳转到班级列表页面
//			response.sendRedirect("");

		} else {
			String errinfo = "<script language='javascript'>alert('账号密码错误，请重新登陆');window.location.href=' html/login.html';</script>";
			response.getWriter().println(errinfo);
		}

	}

}
