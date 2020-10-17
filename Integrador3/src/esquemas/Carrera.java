package esquemas;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Carrera {
	@Id
	private int id;
	@Column
	private String nombre;
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estudiante")
	private List <EstudianteCarrera> estudiantes;
	
	public Carrera(){
		
	}
	public Carrera(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	
	public void addEstudiante(EstudianteCarrera estudiante) {
		estudiantes.add(estudiante);
	}


	public int getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}


	public List<EstudianteCarrera> getEstudiantes() {
		return estudiantes;
	}
	@Override
	public String toString() {
		return "Carrera [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}
