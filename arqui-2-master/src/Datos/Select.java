package Datos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Esquemas.Carrera;
import Esquemas.Estudiante;
import Esquemas.EstudianteCarrera;
import dao.DaoCarrera;
import dao.DaoEstudiante;
import dao.DaoEstudianteCarrera;

public class Select {

	public static void main(String[] args) {
		DaoEstudiante daoEstudiante = new DaoEstudiante();
		DaoCarrera daoCarrera = new DaoCarrera();
		DaoEstudianteCarrera daoEstudianteCarrera = new DaoEstudianteCarrera();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Arqui");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		imprimirEstudiantes(daoEstudiante.recuperarEstudiantes(em));
		//imprimirEstudiante(daoEstudiante.estudianteSegunLibreUniversitaria(444,em));
		//imprimirEstudiantes(daoEstudiante.estudianteSegunGenero("caldo",em));
		//imprimirCarreras(daoCarrera.carrerasSegunInscriptos(em));
		//imprimirEstudiantes(daoEstudiante.estudianteSegunCarreraCiudad(3, "otro",em));
		//imprimirReporteCarreras(daoEstudianteCarrera.reporteCarreras(em));
		em.close();

	}
		
		public static void imprimirEstudiantes(List<Estudiante> estudiantes) {
			if(estudiantes.size() > 0) {
				for(int i = 0; i<estudiantes.size(); i++) {
					System.out.println(estudiantes.get(i).toString());
					}
			}
			else {
				System.out.println("La lista de estudiantes esta vacia");
			}

			}
			
		
		public static void imprimirEstudiante(Estudiante estudiante) {
			if(estudiante!=null) {
				System.out.println(estudiante.toString());
			}
			else {
				System.out.println("El estudiante esta vacio");
			}
			}
		
		
		public static void imprimirCarreras(List<Carrera>  carreras) {
			if(carreras.size() > 0) {
			for(int i = 0; i<carreras.size(); i++) {
				System.out.println(carreras.get(i).toString());
				}
			}
			else {
				System.out.println("La lista de carreras esta vacia");
			}
		}
		
		public static void imprimirReporteCarreras(List<EstudianteCarrera>  reporte) {
			if(reporte.size() > 0) {
			for(int i = 0; i<reporte.size(); i++) {
				if(i>0) {
					if(!reporte.get(i-1).getCarrera().getNombre().equalsIgnoreCase(reporte.get(i).getCarrera().getNombre())) {
						System.out.println(reporte.get(i).getCarrera().toString());
					}
				}
				else {
					System.out.println(reporte.get(i).getCarrera().toString());
				}
				
				System.out.println(reporte.get(i).getEstudiante().toString() + " FechaEgreso " + reporte.get(i).getFechaEgreso());

				}
			}
			else {
				System.out.println("El reporte de carreras esta vacio");
			}
				
		}
		
		
}
