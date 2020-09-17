import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Insert {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Direccion d = new Direccion ("Tandil", "Sarmiento 772");
		em.persist(d);
		Persona p1 = new Persona(0, "Agustin", 24, d);
		em.persist(p1);
		Persona p2 = new Persona(2, "Barbi", 23, d);
		em.persist(p2);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
