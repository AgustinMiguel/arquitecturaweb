package demo.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Compra{
	@Id
	private int id;
	@Column
	private Date fechaDeCompra;
	@OneToMany
	private ArrayList<Producto> productos;
	
	public Compra() {}
	
	public Compra(int id,Date fechaDeCompra) {
		super();
		this.id = id;
		this.productos = new ArrayList<Producto>();
		this.fechaDeCompra = fechaDeCompra;
	}
	
}
