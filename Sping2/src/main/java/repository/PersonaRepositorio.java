package repository;

import model.Persona;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PersonaRepositorio extends JpaRepository<Persona, Long> {
	
	@Query("SELECT t FROM Persona t.surname = :surname")
	public List<Persona> findAllBySurname(String surname);
	
	@Query("SELECT t FROM Persona t WHERE t.name = :name")
	public List<Persona> findAllByName(String name);
	
}
