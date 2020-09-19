import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
public class Select {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
		EntityManager em = emf.createEntityManager();
		List<Estudiante> estudiantes = getEstudiante('m',em);
		for(Estudiante e: estudiantes) {
			System.out.println(e);
		}
		em.close();
	}

	public static List<Estudiante> getEstudiantes(EntityManager em) {
		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Estudiante> estudiantes = em.createQuery("SELECT e from Estudiante e order by edad DESC").getResultList();
		return estudiantes;
	}

	public static Estudiante getEstudiante(int libreta, EntityManager em) {
		em.getTransaction().begin();
		Query query = em.createNamedQuery("buscar estudiante con libreta x");
		query.setParameter("libreta", libreta);
		@SuppressWarnings("unchecked")
		Estudiante estudiante = (Estudiante) query.getSingleResult();
		return estudiante;
	}
	
	public static List<Estudiante> getEstudiante(char genero, EntityManager em) {
		em.getTransaction().begin();
		Query query = em.createNamedQuery("buscar estudiante por genero");
		query.setParameter("genero", genero);
		@SuppressWarnings("unchecked")
		List<Estudiante> estudiantes = query.getResultList();
		return estudiantes;
	}
}
