package demo.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Stock {
	@Id
	//private int id;
	@OneToOne(fetch = FetchType.LAZY, mappedBy="id" )
	private Producto producto;
	@Column
	private int cantidad;
}
