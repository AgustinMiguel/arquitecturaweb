import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
@NamedQuery(query = "Select e from Estudiante e where e.libreta = :libreta", name ="buscar estudiante con libreta x")
@NamedQuery(query = "Select e from Estudiante e where e.genero = :genero", name ="buscar estudiante por genero")
@Entity
public class Estudiante {
	@Id
	protected int dni;
	@Column(nullable = false)
	protected String nombre;
	@Column(nullable = false)
	protected String apellido;
	@Column (nullable = false)
	protected char genero;
	@Column (nullable = false)
	protected int edad;
	@Column(nullable = false)
	protected String ciudad;
	@Column(nullable = false)
	protected int libreta;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "carrera")
	private List<EstudianteCarrera> carreras;
	
	public Estudiante() {
		super();
	}
	
	public Estudiante(int dni, String nombre, String apellido, char genero, int edad, String ciudad, int libreta) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.edad = edad;
		this.ciudad = ciudad;
		this.libreta = libreta;
		this.carreras = new ArrayList<EstudianteCarrera>();
	}
	
	public int getDni() {
		return dni;
	}
	
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public char getGenero() {
		return genero;
	}
	
	public void setGenero(char genero) {
		this.genero = genero;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public int getLibreta() {
		return libreta;
	}
	
	public void setLibreta(int libreta) {
		this.libreta = libreta;
	}
	
	public String toString() {
		return "Estudiante [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", genero=" + genero
				+ ", edad=" + edad + ", ciudad=" + ciudad + ", libreta=" + libreta + "]";
	}
}
