import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
public class Carrera {
	@Id @GeneratedValue
	protected int id;
	@Column
	protected String nombre;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estudiante")
	private List<EstudianteCarrera> estudiantes;
	public Carrera() {
		super();
	}
	
	public Carrera(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void addEstudiante(EstudianteCarrera estudiante) {
		estudiantes.add(estudiante);
	}
	
	public List<EstudianteCarrera> getEstudiantes() {
		return estudiantes;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Carrera [id=" + id + ", nombre=" + nombre + ", estudiantes=" + estudiantes + "]";
	}
}
