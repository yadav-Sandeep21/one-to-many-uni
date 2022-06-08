package com.ty.AccountPage;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.MobileSim.Sim;

public class TestSaveAccountPage {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		User_Account account=new User_Account();
		account.setEmail("sand@gmail.com");
		account.setPassword("san@12345");
		account.setMobile(2345678l);
		account.setName("Instagram");
		
		Page page1=new Page();
		page1.setName("sandeep_insta");
		page1.setTitle("King_of_dark");
		page1.setDescription("Hey this sandeep insta page!");
		
		Page page2=new Page();
		page2.setName("neeraj_insta");
		page2.setTitle("King_of_day");
		page2.setDescription("Hey this neeraj insta page!");
		
		Page page3=new Page();
		page3.setName("nitish_insta");
		page3.setTitle("King_of_midNight");
		page3.setDescription("Hey this nitish insta page!");
		
		List<Page> pages=new ArrayList<Page>();
		pages.add(page1);
		pages.add(page2);
		pages.add(page3);
		
		account.setPage(pages);
		
		entityTransaction.begin();
		entityManager.persist(account);
		entityManager.persist(page1);
		entityManager.persist(page2);
		entityManager.persist(page3);
		entityTransaction.commit();
	}

}
