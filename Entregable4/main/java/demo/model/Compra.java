package demo.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Compra {
	@Id
	private int id;
	@Column
	private Data fechaDeCompra;
	@OneToMany(fetch = FetchType.LAZY, mappedBy="id" )
	private ArrayList<Producto> productos;
	
	public Compra() {}
	
	public Compra(int id, ArrayList<Producto> productos) {
		super();
		this.id = id;
		this.productos = productos;
	}
	
}
