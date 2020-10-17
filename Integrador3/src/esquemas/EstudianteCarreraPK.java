package esquemas;

import java.io.Serializable;

import javax.persistence.Column;

public class EstudianteCarreraPK implements Serializable {

    @Column(name = "ID_Estudiante")
    private int id_Estudiante;

    @Column(name = "ID_Carrera")
    private int id_Carrera;

	public EstudianteCarreraPK(){
		
	}
    
	public EstudianteCarreraPK(int id_Estudiante, int id_Carrera) {
		super();
		this.id_Estudiante = id_Estudiante;
		this.id_Carrera = id_Carrera;
	}

	public int getId_Estudiante() {
		return id_Estudiante;
	}

	public int getId_Carrera() {
		return id_Carrera;
	}
    
    
	
	
}
