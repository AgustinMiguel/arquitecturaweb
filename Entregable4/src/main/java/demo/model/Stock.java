package demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Stock {
	@Id
    private int id;
    @OneToOne
    private Producto producto;
    @Column
    private int cantidad;
}
