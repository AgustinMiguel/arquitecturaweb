package demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import demo.model.Compra;


public interface CompraRepository extends JpaRepository<Compra, Long> {

}
