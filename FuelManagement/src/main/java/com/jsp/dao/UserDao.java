package com.jsp.dao;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.dto.User;

@Repository
public class UserDao {
	@Autowired
  private EntityManager manager;
	
	 public User createUser(User user) {
		   EntityTransaction transaction = manager.getTransaction();
		   transaction.begin();
		   manager.persist(user);
		   transaction.commit();
		   return user;
	   }
	   
	   public User updateUser(User user) {
		   EntityTransaction transaction = manager.getTransaction();
		   User dbuser = manager.find(User.class, user.getId());
		   if(dbuser!=null) {
			   dbuser.setFullname(user.getFullname());
			   dbuser.setEmail(user.getEmail());
			   dbuser.setPassword(user.getPassword());
			   transaction.begin();
			   transaction.commit();
			   return user;
		   }return null;
	   }
	   
	   public User loginUser(String email, String password) {
		   Query query = manager.createQuery("select u from User u where u.email=?1 and u.password=?2");;
		   query.setParameter(1, email);
		   query.setParameter(2, password);
		   try {
			   return (User) query.getSingleResult();
		   }catch(NoResultException e) {
			   return null;
		   }
	   }
}
