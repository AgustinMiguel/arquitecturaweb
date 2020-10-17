package Datos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Esquemas.Carrera;
import Esquemas.Estudiante;
import Esquemas.EstudianteCarrera;
import Esquemas.EstudianteCarreraPK;
import dao.DaoCarrera;
import dao.DaoEstudiante;
import dao.DaoEstudianteCarrera;
public class Insert {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Estudiante e1 = new Estudiante(1,"Agustin","Miguel",25,"m","Tandil",321);
        Carrera c1 = new Carrera(1,"tudai");
        Estudiante e2 = new Estudiante(2,"Mateo","Albert",25,"m","Tandil",322);
        Carrera c2 = new Carrera(2,"tupar");
        Estudiante e3 = new Estudiante(3,"Ezequiel","Balcaldi",25,"m","Tandil",321);
        Carrera c3 = new Carrera(3,"ing. en Sist.");
        Estudiante e4 = new Estudiante(4,"Pablo","Calandria",25,"m","Tandil",321);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Arqui");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		DaoEstudiante daoEstudiante = new DaoEstudiante();
		DaoCarrera daoCarrera = new DaoCarrera();
		DaoEstudianteCarrera daoEstudianteCarrera = new DaoEstudianteCarrera();
		daoEstudiante.insertEstudiante(e1, em);
		daoEstudiante.insertEstudiante(e2, em);
		daoEstudiante.insertEstudiante(e3, em);
		daoEstudiante.insertEstudiante(e4, em);
		
		daoCarrera.insertCarrera(c1,em);
		daoCarrera.insertCarrera(c2,em);
		daoCarrera.insertCarrera(c3,em);
		
		daoEstudianteCarrera.matricularEstudiante(e1,c1,em);
		daoEstudianteCarrera.matricularEstudiante(e2,c2,em);
		daoEstudianteCarrera.matricularEstudiante(e3,c3,em);
		daoEstudianteCarrera.matricularEstudiante(e4,c3,em);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}