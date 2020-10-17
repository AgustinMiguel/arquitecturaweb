package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import Esquemas.Carrera;
import Esquemas.Estudiante;
import Esquemas.EstudianteCarrera;
import Esquemas.EstudianteCarreraPK;

public class DaoEstudianteCarrera {

	public DaoEstudianteCarrera() {

	}
	//b) matricular un estudiante en una carrera
	public  void matricularEstudiante(Estudiante estu, Carrera carr, EntityManager em) {
		EstudianteCarreraPK ecpk = new EstudianteCarreraPK(estu.getDni(),carr.getId());
		//Generamos fechas aleatoreas
		EstudianteCarrera ec = new EstudianteCarrera(ecpk,estu,carr, new Date((long) (System.currentTimeMillis() - Math.random() * 1000000000)));
		em.persist(ec);
	}
	
	/*3)Generar un reporte de las carreras, que para cada carrera incluya informaci�n de los
	inscriptos y egresados por a�o. Se deben ordenar las carreras alfab�ticamente, y presentar
	los a�os de manera cronol�gica.*/
	public List<EstudianteCarrera> reporteCarreras(EntityManager em){
		try {
		@SuppressWarnings("unchecked")
		List <EstudianteCarrera> reporte = em.createQuery("Select ec from EstudianteCarrera ec  join ec.carrera c  where ec.fechaEgreso is not null order by c.nombre,ec.fechaEgreso").getResultList();
		return reporte;
		}
		catch(Exception e){
			return null;
		}
	}
}
