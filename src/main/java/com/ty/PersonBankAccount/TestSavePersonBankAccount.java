package com.ty.PersonBankAccount;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePersonBankAccount {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Person person=new Person();
		person.setName("Neeraj");
		person.setQualification("B.Tech");
		person.setNationality("Indian");
		person.setDob("12-12-1997");
		
		BankAccount bankAccount1=new BankAccount();
		bankAccount1.setBankName("SBI");
		bankAccount1.setBankIfscCode("SBI1234NB");
		bankAccount1.setBanAccountNumber(234567890l);
		bankAccount1.setBranch("MauhaBag Ghazipur");
		
		BankAccount bankAccount2=new BankAccount();
		bankAccount2.setBankName("UBI");
		bankAccount2.setBankIfscCode("UBII1234NB");
		bankAccount2.setBanAccountNumber(9234567890l);
		bankAccount2.setBranch("Bangalore");
		
		BankAccount bankAccount3=new BankAccount();
		bankAccount3.setBankName("ICICI");
		bankAccount3.setBankIfscCode("ICICI1234NB");
		bankAccount3.setBanAccountNumber(834567890l);
		bankAccount3.setBranch("Basvangudi");
		
		List<BankAccount> bankAccount=new ArrayList<BankAccount>();
		bankAccount.add(bankAccount1);
		bankAccount.add(bankAccount2);
		bankAccount.add(bankAccount3);
		
		person.setBankAccount(bankAccount);
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(bankAccount1);
		entityManager.persist(bankAccount2);
		entityManager.persist(bankAccount3);
		entityTransaction.commit();
	}

}
