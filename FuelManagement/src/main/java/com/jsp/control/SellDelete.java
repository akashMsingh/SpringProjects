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
import com.jsp.dao.SellDao;
import com.jsp.dto.StockSellEnt;

@WebServlet("/deletesell")
public class SellDelete extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
		SellDao sdao = context.getBean(SellDao.class);
		int id = Integer.parseInt(req.getParameter("id"));
		StockSellEnt sse = sdao.deleteSell(id);
		HttpSession session = req.getSession();
		if(sse!=null) {
			session.setAttribute("sucMsg", "Item deleted");
			resp.sendRedirect("sellrecords.jsp");
		}else {
			session.setAttribute("errorMsg", "Server Error");
			resp.sendRedirect("sellrecords.jsp");
		}
	}

}
