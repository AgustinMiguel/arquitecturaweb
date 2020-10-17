package restControllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.Cliente;

@Path("/producto")
public class RestProducto {
	//a) dar de alta un cliente
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public void addCliente(Producto p){
		Lector.cliente.addCliente(p);
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCliente(Producto p){
		Lector.cliente.deleteCliente(p);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public void updateCliente(Producto p){
		Lector.cliente.updateCliente(p);
	}
}
