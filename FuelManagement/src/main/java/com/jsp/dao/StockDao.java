package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.dto.StockEnt;

@Repository
public class StockDao {
    @Autowired
	private EntityManager manager;
    
    public StockEnt saveStock(StockEnt stock) {
    	EntityTransaction transaction = manager.getTransaction();
    	transaction.begin();
    	manager.persist(stock);
    	transaction.commit();
    	return stock;
    }
    
    public StockEnt updateStock(StockEnt stock) {
    	StockEnt dbstock = manager.find(StockEnt.class, stock.getId());
    	if(dbstock!=null) {
    		EntityTransaction transaction = manager.getTransaction();
    		dbstock.setEntdate(stock.getEntdate());
    		dbstock.setFuelType(stock.getFuelType());
    		dbstock.setOpenstock(stock.getOpenstock());
    		dbstock.setOpenvalue(stock.getOpenvalue());
    		dbstock.setPurchaseQty(stock.getPurchaseQty());
    		dbstock.setPurchaseRate(stock.getPurchaseRate());
    		dbstock.setPurchaseValue(stock.getPurchaseValue());
    		dbstock.setTotalStock(stock.getTotalStock());
    		dbstock.setTotalValue(stock.getTotalValue());
    		transaction.begin();
    		transaction.commit();
    		return dbstock;
    	}return null;
    }
    
    public StockEnt findStockById(int id) {
    	Query query = manager.createQuery("select s from StockEnt s where s.id=?1");
    	query.setParameter(1, id);
    	try {
			return (StockEnt) query.getSingleResult();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		}
    }
    
    public List<StockEnt> fetchStock(){
    	Query query = manager.createQuery("select s from StockEnt s");
    	try {
			return query.getResultList();
		} catch (NoResultException e) {
			// TODO Auto-generated catch block
			return null;
		}
    }
    
    public StockEnt deleteStock(int id) {
    	StockEnt dbstock = manager.find(StockEnt.class, id);
    	if(dbstock!=null) {
    		EntityTransaction transaction = manager.getTransaction();
    		transaction.begin();
    		manager.remove(dbstock);
    		transaction.commit();
    		return dbstock;
    	}return null;
    }
    
    public List<Double> totalPetrolStock(){
    	Query query = manager.createQuery("select s.purchaseQty from StockEnt s where s.fuelType='Petrol'");
    	return query.getResultList();
    }
    public List<Double> totalMobilStock(){
    	Query query = manager.createQuery("select s.purchaseQty from StockEnt s where s.fuelType = 'Mobil'");
    	return query.getResultList();
    }
    
    public List<Double> totalPowerStock(){
    	Query query = manager.createQuery("select s.purchaseQty from StockEnt s where s.fuelType='Power'");
    	return query.getResultList();
    }
    public List<Double> totalDieselStock(){
    	Query query = manager.createQuery("select s.purchaseQty from StockEnt s where s.fuelType = 'Diesel'");
    	return query.getResultList();
    }
    
    public List<Double> avgPetrol(){
    	Query query = manager.createQuery("select s.purchaseRate from StockEnt s where s.fuelType='Petrol'");
    	return query.getResultList();
    }
    public List<Double> avgMobil(){
    	Query query = manager.createQuery("select s.purchaseRate from StockEnt s where s.fuelType='Mobil'");
    	return query.getResultList();
    }
    
    public List<Double> avgPower(){
    	Query query = manager.createQuery("select s.purchaseRate from StockEnt s where s.fuelType='Power'");
    	return query.getResultList();
    }
    
    public List<Double> avgDiesel(){
    	Query query = manager.createQuery("select s.purchaseRate from StockEnt s where s.fuelType='Diesel'");
    	return query.getResultList();
    }
}
