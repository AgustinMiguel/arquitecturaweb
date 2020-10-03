package dao;

import java.util.List;

import javax.persistence.EntityManager;

import Esquemas.Carrera;

public class DaoCarrera {

	public DaoCarrera() {

	}
	//dar de alta carrera
	public void insertCarrera(Carrera carr, EntityManager em) {
		em.persist(carr);
		
	}
	
	//f)recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos
	public List<Carrera> carrerasSegunInscriptos(EntityManager em){
		try {
		@SuppressWarnings("unchecked")
		List <Carrera> carreras = em.createQuery("Select ec.carrera from Estudiante_Carrera ec group by ID_Carrera having count(ID_Carrera) > 0 order by count(ID_Estudiante) DESC").getResultList();
		return carreras;
		}
		catch(Exception e){
			return null;
		}
	}
	
	
	
	
	
	
}
