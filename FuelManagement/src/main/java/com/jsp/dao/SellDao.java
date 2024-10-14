package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.dto.StockSellEnt;

@Repository
public class SellDao {
	@Autowired
	private EntityManager manager;

	public StockSellEnt saveSell(StockSellEnt sell) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(sell);
		transaction.commit();
		return sell;
	}

	public StockSellEnt updateSellEnt(StockSellEnt stockSell) {
		EntityTransaction transaction = manager.getTransaction();
		StockSellEnt dbsell = manager.find(StockSellEnt.class, stockSell.getId());
		if (dbsell != null) {
			dbsell.setDate(stockSell.getDate());
			dbsell.setFuelType(stockSell.getFuelType());
			dbsell.setSellQty(stockSell.getSellQty());
			dbsell.setSellRate(stockSell.getSellRate());
			dbsell.setTotalstock(stockSell.getTotalstock());
			dbsell.setClosingStock(stockSell.getClosingStock());
			dbsell.setTotalValue(stockSell.getTotalValue());
			dbsell.setpAndl(stockSell.getpAndl());
			dbsell.setSellvalue(stockSell.getSellvalue());
			transaction.begin();
			transaction.commit();
			return stockSell;
		}
		return null;
	}

	public List<StockSellEnt> fetchSell() {
		Query query = manager.createQuery("select s from StockSellEnt s");
		return query.getResultList();
	}

	public StockSellEnt findSellById(int id) {
		Query query = manager.createQuery("select s from StockSellEnt s where s.id=?1");
		query.setParameter(1, id);
		try {
			return (StockSellEnt) query.getSingleResult();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public List<Double> totalSoldPetrol(){
		Query query = manager.createQuery("select s.sellQty from StockSellEnt s where s.FuelType='Petrol'");
		return query.getResultList();
	}
	
	public List<Double> totalSoldMobil(){
		Query query = manager.createQuery("select s.sellQty from StockSellEnt s where s.FuelType='Mobil'");
		return query.getResultList();
	}
	
	public List<Double> totalSoldPower(){
		Query query = manager.createQuery("select s.sellQty from StockSellEnt s where s.FuelType='Power'");
		return query.getResultList();
	}
	
	public List<Double> totalSoldDiesel(){
		Query query = manager.createQuery("select s.sellQty from StockSellEnt s where s.FuelType='Diesel'");
		return query.getResultList();
	}
	
	public StockSellEnt deleteSell(int id) {
		StockSellEnt dbsell = manager.find(StockSellEnt.class, id);
		if(dbsell!=null) {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.remove(dbsell);
			transaction.commit();
			return dbsell;
		}return null;
	}
}
