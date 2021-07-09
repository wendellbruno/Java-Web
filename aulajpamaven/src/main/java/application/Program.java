package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Program {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		Pessoa p = em.find(Pessoa.class, 2); // busca no banco de dados o objeto pela classe e id
		em.getTransaction().begin(); // inicia a transição com o banco
		em.remove(p); // remove o objeto
		em.getTransaction().commit(); // Faz o commit no banco.
		System.out.println(p);
		System.out.println("Pronto!");
		em.close();
		emf.close();
		

	}

}
