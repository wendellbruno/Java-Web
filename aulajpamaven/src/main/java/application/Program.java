package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Program {

	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(null,"Carlos","carlos@gmail.com");
		Pessoa p2 = new Pessoa(null,"Maria","Maria@gmail.com");
		Pessoa p3 = new Pessoa(null,"Pedro","Pedro@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin(); // inicia uma tranci��o para o banco de dados.
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();// faz o commit no banco de dados.
		System.out.println("Pronto!");
		

	}

}
