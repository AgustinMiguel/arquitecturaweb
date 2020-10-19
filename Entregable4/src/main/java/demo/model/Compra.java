package demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "compra")
@Data
public class Compra{
	@Id
	private Long id;
	@Column
	private Date fechaDeCompra;
	@JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProducto", referencedColumnName = "id")
	private List<Producto> productos;
	
	public Compra() {}
	
	public Compra(Long id,Date fechaDeCompra) {
		super();
		this.id = id;
		this.fechaDeCompra = fechaDeCompra;
		this.productos = new ArrayList<Producto>();
	}
	
	public void add(Producto p) {
		productos.add(p);
	}
}
