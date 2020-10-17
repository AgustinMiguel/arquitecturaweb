package restControllers;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dao.DaoCarrera;
import dao.DaoEstudiante;
import dao.DaoEstudianteCarrera;

@WebListener
public class Lector implements ServletContextListener{
		
		    public static DaoCliente cliente = null;
		    public static DaoCompra compra= null;
		    public static DaoProducto producto = null;
		    public static DaoStock stock = null;


			@Override
			public void contextInitialized(ServletContextEvent sce) {
				cliente = new DaoCliente();
				compra = new DaoCompra();
				producto = new DaoProducto();
				stock = new DaoStock();
//				try {
//					Application.csv();
//				} catch (IOException ioException) {
//					System.out.print(ioException);
//				}

			}}

