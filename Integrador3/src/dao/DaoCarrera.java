package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import esquemas.Carrera;
import esquemas.Estudiante;
import esquemas.ReporteCarreras;

public class DaoCarrera {
	private EntityManagerFactory emf = null;

	public DaoCarrera() {
		this.emf = Persistence.createEntityManagerFactory("Arqui");

	}
	
	
	
	public Carrera getCarrera(int id){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
		Query query = em.createQuery("SELECT c from Carrera c where id = :id");
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		Carrera carrera = (Carrera) query.getSingleResult();
		em.close();
		return carrera;
		}
		catch(Exception e){
			em.close();
			return null;
		}
	}
	
	//dar de alta carrera
	public void insertCarrera(Carrera carr) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(carr);
		em.getTransaction().commit();
	}
	
	//f)recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos
	public List<Carrera> carrerasSegunInscriptos(){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
		@SuppressWarnings("unchecked")
		List <Carrera> carreras = em.createQuery("Select ec.carrera from EstudianteCarrera ec group by ID_Carrera having count(ID_Carrera) > 0 order by count(ID_Estudiante) DESC").getResultList();
		return carreras;
		}
		catch(Exception e){
			return null;
		}
	}
	
	
	public List<ReporteCarreras> reporteCarreras(){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
		@SuppressWarnings("unchecked")
		List <Carrera> carreras = em.createQuery("Select c from Carrera c order by id ASC").getResultList();
		List<ReporteCarreras> reportes= new ArrayList<ReporteCarreras>();
		for(Carrera i:carreras) {
			ReporteCarreras reporte = new ReporteCarreras(i.getId());
			Query query =  em.createQuery("Select e from EstudianteCarrera ec  join ec.carrera c join ec.estudiante e  where ec.fechaEgreso is null and c.id =: id ");
			query.setParameter("id", i.getId());
			List <Estudiante> estudiantesInscriptos = (List<Estudiante>) query.getResultList();
			reporte.setInscriptos(estudiantesInscriptos);
			
			Query query2 =  em.createQuery("Select e from EstudianteCarrera ec  join ec.carrera c join ec.estudiante e  where ec.fechaEgreso is not null and c.id =: id ");
			query2.setParameter("id", i.getId());
			List <Estudiante> estudiantesGraduados = (List<Estudiante>) query2.getResultList();
			reporte.setInscriptos(estudiantesInscriptos);
			reporte.setGraduados(estudiantesGraduados);
			reportes.add(reporte);				
			}	
		return reportes;
		}
		catch(Exception e){
			return null;
		}
	}
	
	
	
	
	
	
}
