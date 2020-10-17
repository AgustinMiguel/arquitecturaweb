package restControllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/compra")
public class RestCompra {

	
	//a) dar de alta un cliente
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public void addCompra(Compra c){
		Lector.cliente.addCliente(c);
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCompra(Compra c){
		Lector.cliente.deleteCliente(c);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public void updateCompra(Compra c){
		Lector.cliente.updateCliente(c);
	}
}
