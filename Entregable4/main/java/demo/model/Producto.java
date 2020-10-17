package demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Producto {
	@Id
	private int id;
	@Column
	private String nombre;
	@Column
	private double precio;
	
	public Producto() {}
	
	public Producto(int id, String nombre, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}
}

