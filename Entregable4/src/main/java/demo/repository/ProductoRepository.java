package demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import demo.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

	   @Query("delete FROM Stock s where s.producto = :idProducto")
	    public void borrarStockProducto(long idProducto);
}
