package com.jsp.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jsp.ProjectConfiguration;
import com.jsp.dao.StockDao;
import com.jsp.dao.UserDao;
@WebServlet("/logoutuser")
public class UserLogout extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
		UserDao udao = context.getBean(UserDao.class);
		HttpSession session = req.getSession();
		session.removeAttribute("userObj");
		session.setAttribute("sucMsg", "logout Successfully");
		resp.sendRedirect("userlogin.jsp");
	}

}
