package demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import demo.model.Compra;


public interface CompraRepository extends JpaRepository<Compra, Long> {
	   
	@Query("select c from Compra c order by c.fechaDeCompra")
	    public List<Compra>  comprasOrdenFecha();
	
}
