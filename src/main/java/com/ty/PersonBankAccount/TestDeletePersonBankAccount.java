package com.ty.PersonBankAccount;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestDeletePersonBankAccount {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Person person=entityManager.find(Person.class, 1);
		List<BankAccount> bankAccounts=person.getBankAccount();
		
		entityTransaction.begin();
		for(BankAccount bankAccount:bankAccounts) {
			entityManager.remove(bankAccount);
		}
		entityManager.remove(person);
		entityTransaction.commit();
	}

}
