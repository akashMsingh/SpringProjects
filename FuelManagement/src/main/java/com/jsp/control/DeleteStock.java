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
import com.jsp.dto.StockEnt;
@WebServlet("/deletes")
public class DeleteStock extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
		StockDao sdao = context.getBean(StockDao.class);
		int id = Integer.parseInt(req.getParameter("id"));
		StockEnt s = sdao.deleteStock(id);
		
		HttpSession session = req.getSession();
		if(s!=null) {
			resp.sendRedirect("allstock.jsp");
			session.setAttribute("sucMsg", "Record Deleted Successfully");
		}else {
			resp.sendRedirect("allstock.jsp");
			session.setAttribute("errorMsg", "Server Error");
		}
	}
	

}
