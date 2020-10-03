package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import Esquemas.Carrera;
import Esquemas.Estudiante;
import Esquemas.Estudiante_Carrera;
import Esquemas.Estudiante_CarreraPK;

public class DaoEstudianteCarrera {

	public DaoEstudianteCarrera() {

	}
	//b) matricular un estudiante en una carrera
	public  void matricularEstudiante(Estudiante estu, Carrera carr, EntityManager em) {
		Estudiante_CarreraPK ecpk = new Estudiante_CarreraPK(estu.getDni(),carr.getId());
		//Generamos fechas aleatoreas
		Estudiante_Carrera ec = new Estudiante_Carrera(ecpk,estu,carr, new Date((long) (System.currentTimeMillis() - Math.random() * 1000000000)));
		em.persist(ec);
	}
	
	/*3)Generar un reporte de las carreras, que para cada carrera incluya información de los
	inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
	los años de manera cronológica.*/
	public List<Estudiante_Carrera> reporteCarreras(EntityManager em){
		try {
		@SuppressWarnings("unchecked")
		List <Estudiante_Carrera> reporte = em.createQuery("Select ec from Estudiante_Carrera ec  join ec.carrera c  where ec.fechaEgreso is not null order by c.nombre,ec.fechaEgreso").getResultList();
		return reporte;
		}
		catch(Exception e){
			return null;
		}
	}
}
