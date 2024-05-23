package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MainSQL {

	public static void main(String[] args) {

		// Tạo một phiên Hibernate
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("NguyenNhutAnh_21139431_NHUTANHNGXX");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			System.out.println("Connected to SQL Server successfully!");
			et.commit();
		} catch (Exception e) {
			et.rollback();
		} finally {
			em.close();
			emf.close();
		}
	}

}
