package demo.model;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Stock {
	@Id
	private int id;
}
