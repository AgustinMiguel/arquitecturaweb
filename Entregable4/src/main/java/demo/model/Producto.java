package demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Producto{
	@Id
	private Long id;
	@Column
	private String nombre;
	@Column
	private double precio;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "idStock", referencedColumnName = "id")
//    private Stock stock;
	
	public Producto() {}
	
	public Producto(Long id, String nombre, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	
//	public void setStock(Stock stock) {
//		
//	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public double getPrecio() {
		return this.precio;
	}

}

