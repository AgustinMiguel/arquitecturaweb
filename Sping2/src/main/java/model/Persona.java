package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Persona {
	@Id
	private Long dni;
	@Column
	private String name;
	@Column
	private String surname;
	
	public Persona() {
		
	}
	
	public Persona(Long dni, String name, String surname) {
		super();
		this.dni = dni;
		this.name = name;
		this.surname = surname;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
