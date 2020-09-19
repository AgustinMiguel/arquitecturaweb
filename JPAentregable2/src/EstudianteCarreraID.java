import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class EstudianteCarreraID implements Serializable{
	private static final long serialVersionUID = 1L;
	private int carreraId;
	private int estudianteId;
	public EstudianteCarreraID() {}
	public EstudianteCarreraID(int carreraId, int estudianteId) {
		this.carreraId = carreraId;
		this.estudianteId = estudianteId;
	}
	public int getCarreraId() {
		return carreraId;
	}
	public void setCarreraId(int carreraId) {
		this.carreraId = carreraId;
	}
	public int getEstudianteId() {
		return estudianteId;
	}
	public void setEstudianteId(int estudianteId) {
		this.estudianteId = estudianteId;
	}
	
	public String toString() {
		return "EstudianteCarreraID [carreraId=" + carreraId + ", estudianteId=" + estudianteId + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + carreraId;
		result = prime * result + estudianteId;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstudianteCarreraID other = (EstudianteCarreraID) obj;
		if (carreraId != other.carreraId)
			return false;
		if (estudianteId != other.estudianteId)
			return false;
		return true;
	}
	
		
	
}
