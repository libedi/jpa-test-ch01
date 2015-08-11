package com.libedi.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMainForDetach {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		
		// 회원 엔티티 생성, 비영속 상태
		Member member = new Member();
		member.setId("memberA");
		member.setUsername("회원A");
		
		// 회원 엔티티 영속상태
		em.persist(member);
		
		// 회원 엔티티를 영속성 컨텍스트에서 분리, 준영속 상태
		em.detach(member);
		
		transaction.commit();	// 트랜잭션 커밋
	}

}
