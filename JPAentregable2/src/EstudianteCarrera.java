import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQuery;
@NamedQuery(query = "Select ec from EstudianteCarrera ec group by ec.ID_Carrera having count(ec.ID_Carrera) > 0 order by count(ec.ID_Estudiante) DESC", name ="Buscar carreras con alumnos")
@Entity
public class EstudianteCarrera {
	@EmbeddedId
	private EstudianteCarreraID id = new EstudianteCarreraID();
	@ManyToOne
	@MapsId("estudianteId")
	@JoinColumn(name = "ID_Estudiante")
	private Estudiante estudiante;
	@ManyToOne
	@MapsId("carreraId")
	 @JoinColumn(name = "ID_Carrera")
	private Carrera carrera;
	public EstudianteCarrera() {
	}

	public EstudianteCarrera(EstudianteCarreraID id, Estudiante estudiante, Carrera carrera) {
		this.id = id;
		this.estudiante = estudiante;
		this.carrera = carrera;
	}

	public String toString() {
		return "EstudianteCarrera [estudiante=" + estudiante + ", carrera=" + carrera + "]";
	}

}
