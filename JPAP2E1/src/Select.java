import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Select {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		ArrayList<Persona> personas = (ArrayList<Persona>) em.createQuery("SELECT p FROM Persona p").getResultList();
		for(Persona p: personas){
			System.out.println(p);
		}
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
