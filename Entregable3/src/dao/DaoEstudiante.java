package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import esquemas.Estudiante;

public class DaoEstudiante {

	public DaoEstudiante() {
	}
	
	//a) dar de alta un estudiante
	public void insertEstudiante(Estudiante estu, EntityManager em) {
		em.persist(estu);
	}
	
	//c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple
	public List<Estudiante> recuperarEstudiantes(EntityManager em){
		try {
		@SuppressWarnings("unchecked")
		List <Estudiante> estudiantes = em.createQuery("SELECT e FROM Estudiante e order by edad DESC").getResultList();
		return estudiantes;
		}
		catch(Exception e){
			return null;
		}
		
	}
	
	//d) recuperar un estudiante, en base a su número de libreta universitaria
	public Estudiante estudianteSegunLibreUniversitaria(int numLibreta,EntityManager em){
		try {
		Query query = em.createQuery("SELECT e from Estudiante e where numero_libreta = :numero_libreta");
		query.setParameter("numero_libreta", numLibreta);
		@SuppressWarnings("unchecked")
		Estudiante estudiante = (Estudiante) query.getSingleResult();
		return estudiante;
		}
		catch(Exception e){
			return null;
		}
	}
	
	//e) recuperar todos los estudiantes, en base a su género
	public List<Estudiante> estudianteSegunGenero(String genero,EntityManager em){
		try {
		Query query = em.createQuery("SELECT e from Estudiante e where genero = :genero");
		query.setParameter("genero", genero);
		@SuppressWarnings("unchecked")
		List <Estudiante> estudiantes = query.getResultList();
		return estudiantes;
		}
		catch(Exception e){
			return null;
		}
	}
	
	//g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia
	public List<Estudiante> estudianteSegunCarreraCiudad(int idCarrera, String ciudad,EntityManager em){
		try {
		Query query =  em.createQuery("SELECT ec.estudiante from Estudiante_Carrera ec join ec.estudiante e  join ec.carrera c where e.ciudad_residencia = :ciudad_residencia and c.id = :id ");
		query.setParameter("ciudad_residencia", ciudad);
		query.setParameter("id", idCarrera);
		@SuppressWarnings("unchecked")
		List <Estudiante> carreras = (List<Estudiante>) query.getResultList();
		return carreras;
		}
		catch(Exception e){
			return null;
		}
	}
	
	
	
	
	
}
