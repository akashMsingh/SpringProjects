package com.jsp.control;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jsp.ProjectConfiguration;
import com.jsp.dao.StockDao;
import com.jsp.dto.StockEnt;

public class StockControl {
	
	ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
	StockDao sdao = context.getBean(StockDao.class);
	
	public List<StockEnt> fetchAll(){
		List<StockEnt> stocks = sdao.fetchStock();
		List<StockEnt> stockss = new ArrayList<StockEnt>();
		StockEnt dbstock = null;
		
		try {
			for(StockEnt stock:stocks) {
				dbstock = new StockEnt();
				dbstock.setId(stock.getId());
				dbstock.setEntdate(stock.getEntdate());
				dbstock.setFuelType(stock.getFuelType());
				dbstock.setOpenstock(stock.getOpenstock());
				dbstock.setOpenvalue(stock.getOpenvalue());
				dbstock.setPurchaseQty(stock.getPurchaseQty());
				dbstock.setPurchaseRate(stock.getPurchaseRate());
				dbstock.setPurchaseValue(stock.getPurchaseValue());
				dbstock.setTotalStock(stock.getTotalStock());
				dbstock.setTotalValue(stock.getTotalValue());
				
				stockss.add(dbstock);
			}
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stockss;
	} 
	
	public StockEnt findStockforUpdate(int id) {
		StockEnt dbstock = null;
		StockEnt stock = sdao.findStockById(id);
		if(stock!=null ) {
			dbstock = new StockEnt();
			dbstock.setId(stock.getId());
			dbstock.setEntdate(stock.getEntdate());
			dbstock.setFuelType(stock.getFuelType());
			dbstock.setOpenstock(stock.getOpenstock());
			dbstock.setOpenvalue(stock.getOpenvalue());
			dbstock.setPurchaseQty(stock.getPurchaseQty());
			dbstock.setPurchaseRate(stock.getPurchaseRate());
			dbstock.setPurchaseValue(stock.getPurchaseValue());
			dbstock.setTotalStock(stock.getTotalStock());
			dbstock.setTotalValue(stock.getTotalValue());
			
			
		}
		
		return dbstock;
	}
	
	public double getTotalPetrolStock() {
		List<Double> tps = sdao.totalPetrolStock();
		double  sum = 0;
		if(tps.isEmpty()) {
			return 0;
		}
		else {
			for(Double d:tps) {
				sum = sum + d;
			}
		}
		return sum;
	}
	
	public double getTotalMobilStock() {
		List<Double> tps = sdao.totalMobilStock();
		double  sum = 0;
		if(tps.isEmpty()) {
			return 0;
		}
		else {
			for(Double d:tps) {
				sum = sum + d;
			}
		}
		return sum;
	}
	
	
	public double getTotalPowerStock() {
		List<Double> tps = sdao.totalPowerStock();
		double  sum = 0;
		if(tps.isEmpty()) {
			return 0;
		}
		else {
			for(Double d:tps) {
				sum = sum + d;
			}
		}
		return sum;
	}
	
	public double getTotalDieselSTock() {
		List<Double> tps = sdao.totalDieselStock();
		double  sum = 0;
		if(tps.isEmpty()) {
			return 0;
		}
		else {
			for(Double d:tps) {
				sum = sum + d;
			}
		}
		return sum;
	}
	
	public double getAvgPetrol() {
		List<Double> ag = sdao.avgPetrol();
		double sum = 0;
		double count = 0;
		double emptyval = 0;
		
		if(ag.isEmpty()) {
			return emptyval;
		}else {
			for(Double i:ag) {
				sum = sum + i;
				count++;
			}
			return sum/count;
		}
	}
	
	public double getAvgPower() {
		List<Double> ag = sdao.avgPower();
		double sum = 0;
		double count = 0;
		double emptyval = 0;
		
		if(ag.isEmpty()) {
			return emptyval;
		}else {
			for(Double i:ag) {
				sum = sum + i;
				count++;
			}
			return sum/count;
		}
	}
	
	public double getAvgMobil() {
		List<Double> ag = sdao.avgMobil();
		double sum = 0;
		double count = 0;
		double emptyval = 0;
		
		if(ag.isEmpty()) {
			return emptyval;
		}else {
			for(Double i:ag) {
				sum = sum + i;
				count++;
			}
			return sum/count;
		}
	}
	
	public double getAvgDiesel() {
		List<Double> ag = sdao.avgDiesel();
		double sum = 0;
		double count = 0;
		double emptyval = 0;
		
		if(ag.isEmpty()) {
			return emptyval;
		}else {
			for(Double i:ag) {
				sum = sum + i;
				count++;
			}
			return sum/count;
		}
	}
	
	
   public static void main(String[] args) {
	ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
	StockDao sdao = context.getBean(StockDao.class);
	System.out.println(sdao);
	
}
}
