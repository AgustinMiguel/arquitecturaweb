import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Carrera {
	@Id @GeneratedValue
	protected int id;
	@Column
	protected String nombre;
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Estudiante> estudiantes;
	public Carrera() {
		super();
	}
	
	public Carrera(String nombre, List<Estudiante> estudiantes) {
		super();
		this.nombre = nombre;
		this.estudiantes = estudiantes;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	
	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Carrera [id=" + id + ", nombre=" + nombre + ", estudiantes=" + estudiantes + "]";
	}
}
