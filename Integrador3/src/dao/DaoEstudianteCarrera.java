package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import esquemas.Carrera;
import esquemas.Estudiante;
import esquemas.EstudianteCarrera;
import esquemas.EstudianteCarreraPK;

public class DaoEstudianteCarrera {
	private EntityManagerFactory emf = null;
	private DaoEstudiante daoEstudiante = null;
	private DaoCarrera	  daoCarrera = null;
	
	public DaoEstudianteCarrera() {
		this.emf = Persistence.createEntityManagerFactory("Arqui");
		this.daoEstudiante = new DaoEstudiante();
		this.daoCarrera = new DaoCarrera();
	}
	
	
	//b) matricular un estudiante en una carrera
	public  void matricularEstudiante(int idEstudiante, int idCarrera) {
		EntityManager em = emf.createEntityManager();
		EstudianteCarreraPK ecpk = new EstudianteCarreraPK(idEstudiante,idCarrera);
//		Estudiante e = new Estudiante(1,"Agustin","Miguel",25,"m","Tandil",321);
//		Carrera c = new Carrera(1,"tudai");
//		daoEstudiante.insertEstudiante(e);
//		daoCarrera.insertCarrera(c);
		Estudiante e = daoEstudiante.getEstudiante(idEstudiante);
		Carrera c = daoCarrera.getCarrera(idCarrera);
	//	System.out.println(c.toString());
		//Generamos fechas aleatoreas
		em.getTransaction().begin();
		EstudianteCarrera ec = new EstudianteCarrera(ecpk,e,c, new Date((long) (System.currentTimeMillis() - Math.random() * 1000000000)));
		em.persist(ec);
		em.getTransaction().commit();
		em.close();
	}
	
}
