import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class EstudianteCarrera {
	@EmbeddedId
	private EstudianteCarreraID id = new EstudianteCarreraID();
	@ManyToOne
	@MapsId("estudianteId")
	private Estudiante estudiante;
	@ManyToOne
	@MapsId("carreraId")
	private Carrera carrera;
	
	public EstudianteCarrera() {
	}

	public EstudianteCarrera(EstudianteCarreraID id, Estudiante estudiante, Carrera carrera) {
		this.id = id;
		this.estudiante = estudiante;
		this.carrera = carrera;
	}
	
}
