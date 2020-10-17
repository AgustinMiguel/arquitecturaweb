package restControllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import esquemas.Estudiante;


@Path("/cliente")
public class RestCliente {

	//a) dar de alta un cliente
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public void addCliente(Cliente c){
		Lector.cliente.addCliente(c);
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCliente(Cliente c){
		Lector.cliente.deleteCliente(c);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public void updateCliente(Cliente c){
		Lector.cliente.updateCliente(c);
	}
}
