import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Insert {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Estudiante e1 = new Estudiante(1, "agustin", "miguel", 'm', 20, "tandil", 1);
		Carrera c1 = new Carrera("Tudai");
		EstudianteCarreraID ecID1 = new EstudianteCarreraID(1, 1);
		EstudianteCarrera ec1 = new EstudianteCarrera(ecID1 ,e1, c1);

		em.persist(e1);
		em.persist(c1);
		em.persist(ec1);
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
