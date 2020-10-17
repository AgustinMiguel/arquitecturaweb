package restControllers;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dao.DaoCarrera;
import dao.DaoEstudiante;
import dao.DaoEstudianteCarrera;

@WebListener
public class Lector implements ServletContextListener{

		
		   public static DaoEstudiante estudiante = null;
		    public static DaoCarrera carrera= null;
		    public static DaoEstudianteCarrera estudianteCarrera = null;

			@Override
			public void contextInitialized(ServletContextEvent sce) {
				estudiante = new DaoEstudiante();
				carrera = new DaoCarrera();
				estudianteCarrera = new DaoEstudianteCarrera();
//				try {
//					Application.csv();
//				} catch (IOException ioException) {
//					System.out.print(ioException);
//				}

			}}

