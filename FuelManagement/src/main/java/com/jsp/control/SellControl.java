package com.jsp.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jsp.ProjectConfiguration;
import com.jsp.dao.SellDao;
import com.jsp.dto.StockSellEnt;

public class SellControl  {

	ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
	SellDao sdao = context.getBean(SellDao.class);
	
	public List<StockSellEnt> fetchAllSell(){
		List<StockSellEnt> stocks = sdao.fetchSell();
		List<StockSellEnt> sellss = new ArrayList<StockSellEnt>();
		StockSellEnt dbsell = null;
		
		try {
			for(StockSellEnt stockSell:stocks) {
				dbsell = new StockSellEnt();
				dbsell.setId(stockSell.getId());
				dbsell.setDate(stockSell.getDate());
				dbsell.setFuelType(stockSell.getFuelType());
				dbsell.setSellQty(stockSell.getSellQty());
				dbsell.setSellRate(stockSell.getSellRate());
				dbsell.setTotalstock(stockSell.getTotalstock());
				dbsell.setClosingStock(stockSell.getClosingStock());
				dbsell.setTotalValue(stockSell.getTotalValue());
				dbsell.setpAndl(stockSell.getpAndl());
				dbsell.setSellvalue(stockSell.getSellvalue());
				
				sellss.add(dbsell);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sellss;
	}
	
	public StockSellEnt fetchForUpdate(int id) {
		StockSellEnt stockSell = sdao.findSellById(id);
		StockSellEnt dbsell = null;
		
		if(stockSell!=null) {
			dbsell = new StockSellEnt();
			dbsell.setId(stockSell.getId());
			dbsell.setDate(stockSell.getDate());
			dbsell.setFuelType(stockSell.getFuelType());
			dbsell.setSellQty(stockSell.getSellQty());
			dbsell.setSellRate(stockSell.getSellRate());
			dbsell.setTotalstock(stockSell.getTotalstock());
			dbsell.setClosingStock(stockSell.getClosingStock());
			dbsell.setTotalValue(stockSell.getTotalValue());
			dbsell.setpAndl(stockSell.getpAndl());
			dbsell.setSellvalue(stockSell.getSellvalue());
			
		}
		
		return dbsell;
	}
	
	public double gettotalSoldPetrol(){
		List<Double> tq = sdao.totalSoldPetrol();
		double sum = 0;
	
		
		if(tq.isEmpty()) {
			return 0;
		}else {
			for(Double i:tq) {
				sum = sum + i;
				
			}
			return sum;
		}
	}
	
	public double gettotalSoldPower(){
		List<Double> tq = sdao.totalSoldPower();
		double sum = 0;
		
		
		if(tq.isEmpty()) {
			return 0;
		}else {
			for(Double i:tq) {
				sum = sum + i;
				
			}
			return sum;
		}
	}
	
	public double gettotalSoldMobil(){
		List<Double> tq = sdao.totalSoldMobil();
		double sum = 0;
		int count = 0;
		
		if(tq.isEmpty()) {
			return 0;
		}else {
			for(Double i:tq) {
				sum = sum + i;
				
			}
			return sum;
		}
	}
	
	public double gettotalSoldDiesel(){
		List<Double> tq = sdao.totalSoldDiesel();
		double sum = 0;
		
		
		if(tq.isEmpty()) {
			return 0;
		}else {
			for(Double i:tq) {
				sum = sum + i;
				
			}
			return sum;
		}
	}

}
