package demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import demo.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	   @Query("select SUM(p.precio) from Cliente cl join cl.compras co join co.productos p where cl.id =:id")
	    public int  gastosSegunCliente(Long id);
	   
//	   @Query("select SUM(co.precio*cantidad) from cliente cl join cl.compra co join co.producto p where cl.id :=id ")
//	    public int  compraSegunCliente(Long id);
}
