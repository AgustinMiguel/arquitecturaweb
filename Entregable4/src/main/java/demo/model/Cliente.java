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
public class Cliente {
	@Id
	private int id;
	@Column
	private String nombre;
	@OneToMany(fetch = FetchType.LAZY, mappedBy="id" )
	private ArrayList<Compra> compras;
	
	public Cliente(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.compras = new ArrayList<Compra>();
	} 
	
	public Cliente() {} 
	
}
