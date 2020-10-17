package demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import demo.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
