package Tp3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path ("/usuarios")
public class UsuarioREST {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getUsuarios(){
		return IntStream.range(0, 10).mapToObj(i -> new Usuario(i, "Name_"+i,"SurName_"+i)).collect(Collectors.toList());
	}
}
