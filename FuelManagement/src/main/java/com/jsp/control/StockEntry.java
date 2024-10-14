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
@WebServlet("/Enterthestock")
public class StockEntry extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
		StockDao sdao = context.getBean(StockDao.class);
		   StockEnt s = new StockEnt();
		
		   String date = req.getParameter("date");
		   String fueltype=req.getParameter("fueltype");
		   double openstock = Double.parseDouble(req.getParameter("openingstock"));
		   double purchaserate = Double.parseDouble(req.getParameter("purchaserate"));
		   double openingvalue = openstock*purchaserate;//
		   double purchaseqty = Double.parseDouble(req.getParameter("purchaseqty"));
		   double purchasevalue = purchaserate*purchaseqty;//
		   double totalStock = purchaseqty + Double.parseDouble(req.getParameter("totalstock"));
		   double totalValue= totalStock*purchaserate;
		   
		   s.setEntdate(date);
		   s.setFuelType(fueltype);
		   s.setOpenstock(openstock);
		   s.setOpenvalue(openingvalue);
		   s.setPurchaseQty(purchaseqty);
		   s.setPurchaseRate(purchaserate);
		   s.setPurchaseValue(purchasevalue);
		   s.setTotalStock(totalStock);
		   s.setTotalValue(totalValue);
		   
		   s = sdao.saveStock(s);
		   HttpSession session = req.getSession();
		   if(s!=null ) {
			   resp.sendRedirect(s.getFuelType().toLowerCase()+"entry.jsp");
			   session.setAttribute("sucMsg","Added Successfully");
		   }else {
			   resp.sendRedirect("failed.jsp");
		   }
		  
	}
  
}
