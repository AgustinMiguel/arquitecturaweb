package demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import demo.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
}
