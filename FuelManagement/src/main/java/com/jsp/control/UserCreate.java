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
import com.jsp.dto.User;

@WebServlet("/createuser")
public class UserCreate extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
		UserDao udao = context.getBean(UserDao.class);
		String fullname = req.getParameter("fullname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		User u = new User();

		u.setEmail(email);
		u.setFullname(fullname);
		u.setPassword(password);

		

		HttpSession session = req.getSession();

		u = udao.createUser(u);
		if (u != null) {
			session.setAttribute("sucMsg", "User Registered");
			resp.sendRedirect("createuser.jsp");
		} else {
			session.setAttribute("errorMsg", "Failed");
			resp.sendRedirect("createuser.jsp");
		}
	}

}
