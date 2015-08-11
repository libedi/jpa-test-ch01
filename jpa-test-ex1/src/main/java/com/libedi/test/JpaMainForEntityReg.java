package com.libedi.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMainForEntityReg {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		// 엔티티 매니저는 데이터 변경 시 트랜잭션을 시작해야 한다.
		transaction.begin();		// 트랜잭션 시작
		
		Member memberA = new Member();
		memberA.setId("memberA");
		memberA.setUsername("멤버A");
		memberA.setAge(30);
		
		Member memberB = new Member();
		memberB.setId("memberB");
		memberB.setUsername("멤버B");
		memberB.setAge(33);
		
		em.persist(memberA);
		em.persist(memberB);
		// 여기까지 INSERT SQL을 데이터베이스에 보내지 않는다.
		
		// 커밋하는 순간 데이터베이스에 INSERT SQL을 보낸다.
		transaction.commit();
		
		em.close();
		emf.close();
	}

}
