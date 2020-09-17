import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Persona {
	
	@Id
	private int id;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(name ="anios")
	private int edad;
	
	@ManyToOne
	private Direccion domicilio;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "jugadores")
	private List<Turno> turnos;
	
	public Persona() {
		super();
		turnos = new ArrayList<Turno>();
	}

	public Persona(int id, String nombre, int edad, Direccion domicilio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.domicilio = domicilio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public Direccion getDomicilio() {
		return domicilio;
	}
	
	public void setDomicilio(Direccion domicilio) {
		this.domicilio = domicilio;
	}
	
	public int getId() {
		return id;
	}
	
	public List<Turno> getTurnos() {
		return turnos;
	}

	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", domicilio=" + domicilio + "]";
	}

}
